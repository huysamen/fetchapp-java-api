package com.nicohuysamen.fetchapp.impl.jetty.sync;

import com.nicohuysamen.fetchapp.RequestConstants;
import com.nicohuysamen.fetchapp.dto.Message;
import com.nicohuysamen.fetchapp.dto.NilClasses;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.io.ByteArrayBuffer;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 *
 */
public class JettySyncRequestEngine {

    private final HttpClient httpClient = new HttpClient();

    private String authKey;
    private String appKey;

    public JettySyncRequestEngine(
            final String authKey,
            final String appKey,
            final int maxConnectionsPerAddress,
            final int connectionQueueSize,
            final int connectionTimeout) throws Exception {

        httpClient.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
        httpClient.setMaxConnectionsPerAddress(maxConnectionsPerAddress);
        httpClient.setThreadPool(new QueuedThreadPool(connectionQueueSize));
        httpClient.setTimeout(connectionTimeout);
        httpClient.start();

        this.authKey = authKey;
        this.appKey = appKey;
    }

    public void setAuthKey(final String authKey) {
        this.authKey = authKey;
    }

    public void setAppKey(final String appKey) {
        this.appKey = appKey;
    }

    public synchronized <T> T sendGetRequest(final Class<T> klass, final String method) {
        return sendRequest(klass, RequestConstants.REQUEST_METHOD_GET, method);
    }

    public synchronized <T> T sendPostRequest(final Class<T> klass, final String method, final Object content) {
        return sendDataRequest(klass, RequestConstants.REQUEST_METHOD_POST, method, content);
    }

    public synchronized <T> T sendPutRequest(final Class<T> klass, final String method, final Object content) {
        return sendDataRequest(klass, RequestConstants.REQUEST_METHOD_PUT, method, content);
    }

    public synchronized <T> T sendDeleteRequest(final Class<T> klass, final String method) {
        return sendRequest(klass, RequestConstants.REQUEST_METHOD_DELETE, method);
    }

    @SuppressWarnings("unchecked")
    private <T> T sendRequest(final Class<T> klass, final String requestMethod, final String method) {
        try {
            final JAXBContext context = JAXBContext.newInstance("com.nicohuysamen.fetchapp.dto");
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            final ContentExchange exchange = new ContentExchange();

            exchange.setMethod(requestMethod);
            exchange.setRequestHeader(RequestConstants.REQUEST_HEADER_AUTH, authKey);
            exchange.setRequestContentType(RequestConstants.REQUEST_CONTENT_XML);
            exchange.setURL(RequestConstants.generateRequestUrl(appKey, method));

            httpClient.send(exchange);
            exchange.waitForDone();

            final Object response = unmarshaller.unmarshal(new StringReader(exchange.getResponseContent()));

            if ((response instanceof Message && !klass.equals(Message.class))
                    || response instanceof NilClasses) {

                // TODO: Log error
                return null;
            }

            return (T) response;

        } catch (final JAXBException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> T sendDataRequest(
            final Class<T> klass,
            final String requestMethod,
            final String method,
            final Object content) {

        try {
            final JAXBContext context = JAXBContext.newInstance("com.nicohuysamen.fetchapp.dto");
            final Marshaller marshaller = context.createMarshaller();
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            final ContentExchange exchange = new ContentExchange();

            exchange.setMethod(requestMethod);
            exchange.setRequestHeader(RequestConstants.REQUEST_HEADER_AUTH, authKey);
            exchange.setRequestContentType(RequestConstants.REQUEST_CONTENT_XML);
            exchange.setURL(RequestConstants.generateRequestUrl(appKey, method));

            if (content != null) {
                final StringWriter xml = new StringWriter();
                marshaller.marshal(content, xml);
                exchange.setRequestContent(new ByteArrayBuffer(xml.toString()));
            }

            httpClient.send(exchange);
            exchange.waitForDone();

            final Object response = unmarshaller.unmarshal(new StringReader(exchange.getResponseContent()));

            if ((response instanceof Message && !klass.equals(Message.class))
                    || response instanceof NilClasses) {

                // TODO: Log error
                return null;
            }

            return (T) response;

        } catch (final JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
