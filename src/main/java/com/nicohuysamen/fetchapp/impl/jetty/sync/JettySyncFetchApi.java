/*
* JettySyncFetchApi.java
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

package com.nicohuysamen.fetchapp.impl.jetty.sync;

import com.nicohuysamen.fetchapp.FetchApi;
import com.nicohuysamen.fetchapp.RequestConstants;
import com.nicohuysamen.fetchapp.dto.*;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

/**
 *
 */
public class JettySyncFetchApi implements FetchApi {

    private final JettySyncRequestEngine engine;

    private String apiKey;
    private String authKey;

    public JettySyncFetchApi(
            final String appKey,
            final String apiKey,
            final String apiToken) throws Exception {

        this(appKey, apiKey, apiToken, 10, 100, 5000);
    }

    public JettySyncFetchApi(
            final String appKey,
            final String apiKey,
            final String apiToken,
            final int maxConnectionsPerAddress,
            final int connectionQueueSize,
            final int connectionTimeout) throws Exception {

        this.apiKey = apiKey;
        this.authKey = RequestConstants.generateAuthorizationKey(apiKey, apiToken);
        this.engine = new JettySyncRequestEngine(
                authKey,
                appKey,
                maxConnectionsPerAddress,
                connectionQueueSize,
                connectionTimeout);
    }


    // -----------------------------------------------------------------------------------------------------------------
    // ACCOUNT MANAGEMENT
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public synchronized Account getAccountInformation() {
        return engine.sendGetRequest(Account.class, RequestConstants.Account.METHOD_INFORMATION);
    }

    @Override
    public synchronized String newApiToken() {
        final Message message = engine.sendGetRequest(Message.class, RequestConstants.Account.METHOD_NEW_TOKEN);

        if (message != null) {
            authKey = RequestConstants.generateAuthorizationKey(apiKey, message.getMessage());
            return message.getMessage();
        }

        return null;
    }


    // -----------------------------------------------------------------------------------------------------------------
    // ORDER MANAGEMENT
    // -----------------------------------------------------------------------------------------------------------------


    @Override
    public Orders getOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS);
    }

    @Override
    public Orders getOpenOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS_OPEN);
    }

    @Override
    public Orders getExpiredOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS_EXPIRED);
    }

    @Override
    public Order getOrder(final String id) {
        return engine.sendGetRequest(Order.class, RequestConstants.Orders.orderRequestUrl(id));
    }

    @Override
    public Order createOrder(final Order order) {
        return engine.sendPostRequest(Order.class, RequestConstants.Orders.METHOD_ORDER_CREATE, order);
    }

    @Override
    public Order updateOrder(final Order order) {
        return engine.sendPutRequest(Order.class, RequestConstants.Orders.orderUpdateRequestUrl(order.getId()), order);
    }

    @Override
    public Message deleteOrder(final String id) {
        return engine.sendDeleteRequest(Message.class, RequestConstants.Orders.orderDeleteRequestUrl(id));
    }

    @Override
    public Downloads orderDownloads(final String id) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.Orders.orderDownloadsRequestUrl(id));
    }

    @Override
    public Message expireOrder(final String id) {
        return engine.sendGetRequest(Message.class, RequestConstants.Orders.orderExpireRequestUrl(id));
    }

    @Override
    public Message sendOrderEmail(final String id, final boolean resetExpiration) {
        return engine.sendPostRequest(
                Message.class,
                RequestConstants.Orders.orderSendEmailRequestUrl(id, resetExpiration),
                null);
    }

    @Override
    public Message sendOrderEmail(final String id, final Date expirationDate) {
        return engine.sendPostRequest(
                Message.class,
                RequestConstants.Orders.orderSendEmailRequestUrl(id, expirationDate),
                null);
    }

    @Override
    public Order getOrderStatistics(final String id) {
        return engine.sendGetRequest(Order.class, RequestConstants.Orders.orderStatsRequestUrl(id));
    }


    // -----------------------------------------------------------------------------------------------------------------
    // ORDER ITEM MANAGEMENT
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public OrderItems getOrderItems(final String id) {
        return engine.sendGetRequest(OrderItems.class, RequestConstants.OrderItems.orderItemsRequestUrl(id));
    }

    @Override
    public OrderItem getOrderItem(final String orderId, final String id) {
        return engine.sendGetRequest(OrderItem.class, RequestConstants.OrderItems.orderItemRequestUrl(orderId, id));
    }

    @Override
    public Files getOrderItemFiles(final String orderId, final String id) {
        return engine.sendGetRequest(Files.class, RequestConstants.OrderItems.orderItemFilesRequestUrl(orderId, id));
    }

    @Override
    public Downloads getOrderItemDownloads(final String orderId, final String id) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.OrderItems.orderItemDownloadsRequestUrl(orderId, id));
    }

//    @Override
//    public Message expireOrderItem(final String orderId, final String id) {
//        return engine.sendGetRequest(Message.class, RequestConstants.OrderItems.orderItemExpireRequestUrl(orderId, id));
//    }


    // -----------------------------------------------------------------------------------------------------------------
    // PRODUCT MANAGEMENT
    // -----------------------------------------------------------------------------------------------------------------


    @Override
    public Products getProducts() {
        return engine.sendGetRequest(Products.class, RequestConstants.Products.METHOD_PRODUCTS);
    }

    @Override
    public Product getProduct(final String sku) {
        return engine.sendGetRequest(Product.class, RequestConstants.Products.productRequestUrl(sku));
    }

    @Override
    public Product createProduct(final Product product) {
        return engine.sendPostRequest(Product.class, RequestConstants.Products.METHOD_PRODUCT_CREATE, product);
    }

    @Override
    public Product updateProduct(final Product product) {
        return engine.sendPutRequest(Product.class, RequestConstants.Products.productUpdateRequestUrl(product.getSku()), product);
    }

    @Override
    public Message deleteProduct(final String sku) {
        return engine.sendDeleteRequest(Message.class, RequestConstants.Products.productDeleteRequestUrl(sku));
    }

    @Override
    public Product getProductStatistics(final String sku) {
        return engine.sendGetRequest(Product.class, RequestConstants.Products.productStatisticsRequestUrl(sku));
    }

    @Override
    public Files getProductFiles(final String sku) {
        return engine.sendGetRequest(Files.class, RequestConstants.Products.productFilesRequestUrl(sku));
    }

    @Override
    public Downloads getProductDownloads(final String sku) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.Products.productDownloadsRequestUrl(sku));
    }
}
