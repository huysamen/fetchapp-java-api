/*
* JettyAsyncFetchApi.java
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
import com.nicohuysamen.fetchapp.FetchAsyncApi;
import com.nicohuysamen.fetchapp.RequestConstants;
import com.nicohuysamen.fetchapp.dto.*;

import java.util.Date;

/**
 *
 */
public class JettyAsyncFetchApi implements FetchAsyncApi {

    private final JettyAsyncRequestEngine engine;

    private String apiKey;
    private String authKey;

    public JettyAsyncFetchApi(
            final String apiKey,
            final String apiToken) throws Exception {

        this(apiKey, apiToken, 10, 100, 10000);
    }

    public JettyAsyncFetchApi(
            final String apiKey,
            final String apiToken,
            final int maxConnectionsPerAddress,
            final int connectionQueueSize,
            final int connectionTimeout) throws Exception {

        this.apiKey = apiKey;
        this.authKey = RequestConstants.generateAuthorizationKey(apiKey, apiToken);
        this.engine = new JettyAsyncRequestEngine(
                authKey,
                maxConnectionsPerAddress,
                connectionQueueSize,
                connectionTimeout);
    }

    public void updateApiToken(final String apiToken) {
        authKey = RequestConstants.generateAuthorizationKey(apiKey, apiToken);
        engine.setAuthKey(authKey);
    }

    @Override
    public ListenableFuture<Account> getAccountInformation() {
        return engine.sendGetRequest(Account.class, RequestConstants.Account.METHOD_INFORMATION);
    }

    @Override
    public ListenableFuture<Message> requestNewApiToken() {
        return engine.sendGetRequest(Message.class, RequestConstants.Account.METHOD_NEW_TOKEN);
    }

    @Override
    public ListenableFuture<Files> getFiles() {
        return engine.sendGetRequest(Files.class, RequestConstants.Files.METHOD_FILES);
    }

    @Override
    public ListenableFuture<Downloads> getDownloads() {
        return engine.sendGetRequest(Downloads.class, RequestConstants.Downloads.METHOD_DOWNLOADS);
    }

    @Override
    public ListenableFuture<Orders> getOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS);
    }

    @Override
    public ListenableFuture<Orders> getOpenOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS_OPEN);
    }

    @Override
    public ListenableFuture<Orders> getExpiredOrders() {
        return engine.sendGetRequest(Orders.class, RequestConstants.Orders.METHOD_ORDERS_EXPIRED);
    }

    @Override
    public ListenableFuture<Order> getOrder(final String id) {
        return engine.sendGetRequest(Order.class, RequestConstants.Orders.orderRequestUrl(id));
    }

    @Override
    public ListenableFuture<Order> createOrder(final OrderData order) {
        return engine.sendPostRequest(OrderData.class, Order.class, RequestConstants.Orders.METHOD_ORDER_CREATE, order);
    }

    @Override
    public ListenableFuture<Order> updateOrder(final OrderData order) {
        return engine.sendPutRequest(OrderData.class, Order.class, RequestConstants.Orders.orderUpdateRequestUrl(order.getId()), order);
    }

    @Override
    public ListenableFuture<Message> deleteOrder(final String id) {
        return engine.sendDeleteRequest(Message.class, RequestConstants.Orders.orderDeleteRequestUrl(id));
    }

    @Override
    public ListenableFuture<Downloads> getOrderDownloads(final String id) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.Orders.orderDownloadsRequestUrl(id));
    }

    @Override
    public ListenableFuture<Message> expireOrder(final String id) {
        return engine.sendGetRequest(Message.class, RequestConstants.Orders.orderExpireRequestUrl(id));
    }

    @Override
    public ListenableFuture<Message> sendOrderEmail(final String id, final boolean resetExpiration) {
        return engine.sendPostRequest(
                Void.class,
                Message.class,
                RequestConstants.Orders.orderSendEmailRequestUrl(id, resetExpiration),
                null);
    }

    @Override
    public ListenableFuture<Message> sendOrderEmail(final String id, final Date expirationDate) {
        return engine.sendPostRequest(
                Void.class,
                Message.class,
                RequestConstants.Orders.orderSendEmailRequestUrl(id, expirationDate),
                null);
    }

    @Override
    public ListenableFuture<OrderStats> getOrderStatistics(final String id) {
        return engine.sendGetRequest(OrderStats.class, RequestConstants.Orders.orderStatsRequestUrl(id));
    }

    @Override
    public ListenableFuture<OrderItems> getOrderItems(final String id) {
        return engine.sendGetRequest(OrderItems.class, RequestConstants.OrderItems.orderItemsRequestUrl(id));
    }

    @Override
    public ListenableFuture<OrderItem> getOrderItem(final String orderId, final String id) {
        return engine.sendGetRequest(OrderItem.class, RequestConstants.OrderItems.orderItemRequestUrl(orderId, id));
    }

    @Override
    public ListenableFuture<OrderItemFiles> getOrderItemFiles(final String orderId, final String id) {
        return engine.sendGetRequest(OrderItemFiles.class, RequestConstants.OrderItems.orderItemFilesRequestUrl(orderId, id));
    }

    @Override
    public ListenableFuture<Downloads> getOrderItemDownloads(final String orderId, final String id) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.OrderItems.orderItemDownloadsRequestUrl(orderId, id));
    }

    @Override
    public ListenableFuture<Products> getProducts() {
        return engine.sendGetRequest(Products.class, RequestConstants.Products.METHOD_PRODUCTS);
    }

    @Override
    public ListenableFuture<Product> getProduct(final String sku) {
        return engine.sendGetRequest(Product.class, RequestConstants.Products.productRequestUrl(sku));
    }

    @Override
    public ListenableFuture<Product> createProduct(final ProductData product) {
        return engine.sendPostRequest(ProductData.class, Product.class, RequestConstants.Products.METHOD_PRODUCT_CREATE, product);
    }

    @Override
    public ListenableFuture<Product> updateProduct(final ProductData product) {
        return engine.sendPutRequest(ProductData.class, Product.class, RequestConstants.Products.productUpdateRequestUrl(product.getSku()), product);
    }

    @Override
    public ListenableFuture<Message> deleteProduct(final String sku) {
        return engine.sendDeleteRequest(Message.class, RequestConstants.Products.productDeleteRequestUrl(sku));
    }

    @Override
    public ListenableFuture<ProductStats> getProductStatistics(final String sku) {
        return engine.sendGetRequest(ProductStats.class, RequestConstants.Products.productStatisticsRequestUrl(sku));
    }

    @Override
    public ListenableFuture<Files> getProductFiles(final String sku) {
        return engine.sendGetRequest(Files.class, RequestConstants.Products.productFilesRequestUrl(sku));
    }

    @Override
    public ListenableFuture<Downloads> getProductDownloads(final String sku) {
        return engine.sendGetRequest(Downloads.class, RequestConstants.Products.productDownloadsRequestUrl(sku));
    }
}
