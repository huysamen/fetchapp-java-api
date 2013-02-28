package com.nicohuysamen.fetchapp;

import com.nicohuysamen.fetchapp.dto.*;

import java.util.Date;

/**
 *
 */
public interface FetchApi {

    // ACCOUNT MANAGEMENT
    //
    public Account getAccountInformation();
    public String newApiToken();


    // ORDER MANAGEMENT
    //
    public Orders getOrders();
    public Orders getOpenOrders();
    public Orders getExpiredOrders();
    public Order getOrder(final String id);
    public Order createOrder(final Order order);
    public Order updateOrder(final Order order);
    public Message deleteOrder(final String id);
    public Downloads orderDownloads(final String id);
    public Message expireOrder(final String id);
    public Message sendOrderEmail(final String id, final boolean resetExpiration);
    public Message sendOrderEmail(final String id, final Date expirationDate);
    public Order getOrderStatistics(final String id);


    // ORDER ITEM MANAGEMENT
    //
    public OrderItems getOrderItems(final String id);
    public OrderItem getOrderItem(final String orderId, final String id);
    public Files getOrderItemFiles(final String orderId, final String id);
    public Downloads getOrderItemDownloads(final String orderId, final String id);
//    public Message expireOrderItem(final String orderId, final String id);


    // PRODUCT MANAGEMENT
    //
    public Products getProducts();
    public Product getProduct(final String sku);
    public Product createProduct(final Product product);
    public Product updateProduct(final Product product);
    public Message deleteProduct(final String sku);
    public Product getProductStatistics(final String sku);
    public Files getProductFiles(final String sku);
    public Downloads getProductDownloads(final String sku);
}
