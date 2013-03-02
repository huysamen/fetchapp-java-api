/*
* FetchAsyncApi.java
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

package com.nicohuysamen.fetchapp;

import com.google.common.util.concurrent.ListenableFuture;
import com.nicohuysamen.fetchapp.dto.*;

import java.util.Date;

/**
 *
 */
public interface FetchAsyncApi {

    /**
     * Returns the account information for your FetchApp account.
     *
     * @return - Your account information.
     */
    public ListenableFuture<Account> getAccountInformation();

    /**
     * Returns your new API token in the message.
     *
     * @return - Your new API token.
     */
    public ListenableFuture<Message> requestNewApiToken();

    /**
     * Returns all the files that have been uploaded your FetchApp account.
     *
     * @return - The files uploaded to your FetchApp account.
     */
    public ListenableFuture<Files> getFiles();

    /**
     * Returns all the downloads for your FetchApp account.
     *
     * @return - The downloads that have happened on your FetchApp account.
     */
    public ListenableFuture<Downloads> getDownloads();

    /**
     * Returns all orders associated with your FetchApp account.
     *
     * @return - All orders associated with your account.
     */
    public ListenableFuture<Orders> getOrders();

    /**
     * Returns all open orders.
     *
     * @return - All open orders.
     */
    public ListenableFuture<Orders> getOpenOrders();

    /**
     * Returns all expired orders.
     *
     * @return - All expired orders.
     */
    public ListenableFuture<Orders> getExpiredOrders();

    /**
     * Return a specific order.
     *
     * @param id - The ID of the order being queried.
     * @return - The specific order.
     */
    public ListenableFuture<Order> getOrder(final String id);

    /**
     * Creates an <code>Order</code> from the data specified in the <code>OrderData</order> class.
     *
     * @param order - The new order data.
     * @return - The newly created order.
     */
    public ListenableFuture<Order> createOrder(final OrderData order);

    /**
     * Updates an existing order with the information in the order data object.
     *
     * @param order - The order data to update the existing order with.
     * @return - The updated order.
     */
    public ListenableFuture<Order> updateOrder(final OrderData order);

    /**
     * Deletes a specific order.
     *
     * @param id - The ID of the order to delete.
     * @return - A message with 'Ok.' if successful.
     */
    public ListenableFuture<Message> deleteOrder(final String id);

    /**
     * Returns all the downloads for a specific order.
     *
     * @param id - The ID of the order whose downloads are requested.
     * @return - The downloads of the order.
     */
    public ListenableFuture<Downloads> getOrderDownloads(final String id);

    /**
     * Expire an existing order.
     *
     * @param id - The ID of the order to expire.
     * @return - A message with 'Ok.' if successful.
     */
    public ListenableFuture<Message> expireOrder(final String id);

    /**
     * Resend the order e-mail for a specific order.
     *
     * @param id - The ID of the order which e-mail must be sent again.
     * @param resetExpiration - Flag to indicate if the expiration should be removed or not.
     * @return - A message with 'Ok.' if successful.
     */
    public ListenableFuture<Message> sendOrderEmail(final String id, final boolean resetExpiration);

    /**
     * Resend the order e-mail for a specific order, and set a new expiration date.
     *
     * @param id - The ID of the order which e-mail must be sent again.
     * @param expirationDate - The date when the order should expire.
     * @return - A message with 'Ok.' if successful.
     */
    public ListenableFuture<Message> sendOrderEmail(final String id, final Date expirationDate);

    /**
     * Get some statistics for a specific order.
     *
     * @param id - The ID of the order which statistics is requested.
     * @return - The statistics for the order.
     */
    public ListenableFuture<OrderStats> getOrderStatistics(final String id);

    /**
     * Returns all the order items associated with a specific order.
     *
     * @param id - The ID of the order for which the order items is requested.
     * @return - The order items for the order.
     */
    public ListenableFuture<OrderItems> getOrderItems(final String id);

    /**
     * Returns a specific order item.
     *
     * @param orderId - The ID of the order which the order item belongs to.
     * @param id - The ID of the order item.
     * @return - The order item.
     */
    public ListenableFuture<OrderItem> getOrderItem(final String orderId, final String id);

    /**
     * Returns all the files associated with a specific order item.
     *
     * @param orderId - The ID of the order which the order item belongs to.
     * @param id - The ID of the order item.
     * @return - The files associated wit the order item.
     */
    public ListenableFuture<OrderItemFiles> getOrderItemFiles(final String orderId, final String id);

    /**
     * Returns all the downloads associated with a specific order item.
     *
     * @param orderId - The ID of the order which the order item belongs to.
     * @param id - The ID of the order item.
     * @return - The downloads associated wit the order item.
     */
    public ListenableFuture<Downloads> getOrderItemDownloads(final String orderId, final String id);

    /**
     * Returns all the products associated with your FetchApp account.
     *
     * @return - All the products.
     */
    public ListenableFuture<Products> getProducts();

    /**
     * Returns a specific product.
     *
     * @param sku - The SKU of the product.
     * @return - The Specific product.
     */
    public ListenableFuture<Product> getProduct(final String sku);

    /**
     * Create a product from a product data object.
     *
     * @param product - The product data from which the product will be created.
     * @return - The newly created product.
     */
    public ListenableFuture<Product> createProduct(final ProductData product);

    /**
     * Update an existing product from a product data object.
     *
     * @param product - The product data object.
     * @return - The updated product.
     */
    public ListenableFuture<Product> updateProduct(final ProductData product);

    /**
     * Delete a specific product.
     *
     * @param sku - The SKU of the product to delete.
     * @return - A message with 'Ok.' if successful.
     */
    public ListenableFuture<Message> deleteProduct(final String sku);

    /**
     * Get statistics for a specific product.
     *
     * @param sku - The SKU of the product to get the statistics for.
     * @return - The statistics of the product.
     */
    public ListenableFuture<ProductStats> getProductStatistics(final String sku);

    /**
     * Returns all the files associated with a product.
     *
     * @param sku - The SKU of the product which files must be fetched.
     * @return - The files associated with the product.
     */
    public ListenableFuture<Files> getProductFiles(final String sku);

    /**
     * Returns all the downloads associated with a product.
     *
     * @param sku - The SKU of the product which downloads must be fetched.
     * @return - The downloads associated with the product.
     */
    public ListenableFuture<Downloads> getProductDownloads(final String sku);
}
