/*
* JettyAsyncRequestEngine.java
*
* Copyright (c) 2013, Nicolaas Frederick Huysamen. All rights reserved.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301 USA
*/

package com.nicohuysamen.fetchapp.impl.jetty.async;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.nicohuysamen.fetchapp.RequestConstants;
import com.nicohuysamen.fetchapp.dto.Message;
import com.nicohuysamen.fetchapp.impl.jetty.AbstractJettyRequestEngine;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.io.ByteArrayBuffer;

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
class JettyAsyncRequestEngine extends AbstractJettyRequestEngine {

    protected JettyAsyncRequestEngine(
            final String authKey,
            final int maxConnectionsPerAddress,
            final int connectionQueueSize,
            final int connectionTimeout) throws Exception {

        super(authKey, maxConnectionsPerAddress, connectionQueueSize, connectionTimeout);
    }

    protected synchronized <R> ListenableFuture<R> sendGetRequest(
            final Class<R> receiveClass,
            final String method) {

        return sendRequest(Void.class, receiveClass, RequestConstants.REQUEST_METHOD_GET, method, null);
    }

    protected synchronized <R> ListenableFuture<R> sendDeleteRequest(
            final Class<R> receiveClass,
            final String method) {

        return sendRequest(Void.class, receiveClass, RequestConstants.REQUEST_METHOD_DELETE, method, null);
    }

    protected synchronized <S, R> ListenableFuture<R> sendPostRequest(
            final Class<S> sendClass,
            final Class<R> receiveClass,
            final String method,
            final S content) {

        return sendRequest(sendClass, receiveClass, RequestConstants.REQUEST_METHOD_POST, method, content);
    }

    protected synchronized <S, R> ListenableFuture<R> sendPutRequest(
            final Class<S> sendClass,
            final Class<R> receiveClass,
            final String method,
            final S content) {

        return sendRequest(sendClass, receiveClass, RequestConstants.REQUEST_METHOD_PUT, method, content);
    }

    @SuppressWarnings("unchecked")
    private <S, R> ListenableFuture<R> sendRequest(
            final Class<S> sendClass,
            final Class<R> receiveClass,
            final String requestMethod,
            final String method,
            final S content) {

        final SettableFuture<R> future = SettableFuture.create();
        final ContentExchange exchange = new ContentExchange(true) {
            @Override
            protected void onResponseComplete() throws IOException {
                try {
                    if (getResponseStatus() >= 200 && getResponseStatus() < 300) {
                        JAXBContext receiveContext = JAXBContext.newInstance("com.nicohuysamen.fetchapp.dto");
                        Unmarshaller unmarshaller = receiveContext.createUnmarshaller();
                        Object response = unmarshaller.unmarshal(new StringReader(getResponseContent()));

                        if ((response instanceof Message && !receiveClass.equals(Message.class))) {
                            // TODO: Log error
                            System.err.println(((Message) response).getMessage());
                            future.set(null);
                            return;
                        } else if (!response.getClass().equals(receiveClass)) {
                            receiveContext = JAXBContext.newInstance(receiveClass);
                            unmarshaller = receiveContext.createUnmarshaller();
                            response = unmarshaller.unmarshal(new StringReader(getResponseContent()));
                        }

                        future.set((R) response);
                    } else {
                        future.set(null);
                    }
                } catch (final JAXBException e) {
                    future.setException(e);
                    future.set(null);
                } catch (IOException e) {
                    future.setException(e);
                    future.set(null);
                }
            }
        };

        exchange.setMethod(requestMethod);
        exchange.setRequestHeader(RequestConstants.REQUEST_HEADER_AUTH, authKey);
        exchange.setRequestContentType(RequestConstants.REQUEST_CONTENT_XML);
        exchange.setURL(RequestConstants.generateRequestUrl(method));

        try {
            if (content != null) {
                final JAXBContext sendContext = JAXBContext.newInstance(sendClass);
                final Marshaller marshaller = sendContext.createMarshaller();
                final StringWriter xml = new StringWriter();

                marshaller.marshal(content, xml);
                exchange.setRequestContent(new ByteArrayBuffer(xml.toString()));
            }

            httpClient.send(exchange);

        } catch (final JAXBException e) {
            future.setException(e);
            future.set(null);
        } catch (IOException e) {
            future.setException(e);
            future.set(null);
        }

        return future;
    }
}
