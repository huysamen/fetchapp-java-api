package com.nicohuysamen.fetchapp;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class RequestConstants {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String REQUEST_METHOD_PUT = "PUT";
    public static final String REQUEST_METHOD_DELETE = "DELETE";
    public static final String REQUEST_HEADER_AUTH = "Authorization";
    public static final String REQUEST_CONTENT_XML = "application/xml";

    public static final String TOKEN_ID = "${id}";
    public static final String TOKEN_ORDER_ID = "${orderId}";
    public static final String TOKEN_METHOD = "${method}";
    public static final String TOKEN_APP_KEY = "${appKey}";
    public static final String TOKEN_RESET = "${reset}";
    public static final String TOKEN_SKU = "${sku}";

    public static final String BASE_URL = "http://" + TOKEN_APP_KEY + ".fetchapp.com/api/v2/" + TOKEN_METHOD;
    public static final String[] BASE_URL_SEARCH = {TOKEN_APP_KEY, TOKEN_METHOD};

    public static String generateAuthorizationKey(final String apiKey, final String apiToken) {
        return "Basic " + Base64.encodeBase64String((apiKey + ":" + apiToken).getBytes());
    }

    public static String generateRequestUrl(final String appKey, final String method) {
        return StringUtils.replaceEach(BASE_URL, BASE_URL_SEARCH, new String[] {appKey, method});
    }


    public static final class Account {

        public static final String METHOD_INFORMATION = "account";
        public static final String METHOD_NEW_TOKEN = "new_token";
    }


    public static final class Orders {

        private static final String METHOD_ORDER = "orders/" + TOKEN_ID;
        private static final String METHOD_ORDER_UPDATE = "orders/" + TOKEN_ID + "/update";
        private static final String METHOD_ORDER_DELETE = "orders/" + TOKEN_ID + "/delete";
        private static final String METHOD_ORDER_DOWNLOADS = "orders/" + TOKEN_ID + "/downloads";
        private static final String METHOD_ORDER_EXPIRE = "orders/" + TOKEN_ID + "/expire";
        private static final String METHOD_ORDER_EMAIL = "orders/" + TOKEN_ID + "/send_email?reset_expiration=" + TOKEN_RESET;
        private static final String METHOD_ORDER_EMAIL_DATE = "orders/" + TOKEN_ID + "/send_email?expiration_date=" + TOKEN_RESET;

        private static final String METHOD_ORDER_STATS = "orders/" + TOKEN_ID + "/stats";
        public static final String METHOD_ORDERS = "orders";
        public static final String METHOD_ORDERS_OPEN = "orders?status=open";
        public static final String METHOD_ORDERS_EXPIRED = "orders?status=expired";
        public static final String METHOD_ORDER_CREATE = "orders/create";

        public static String orderRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER, TOKEN_ID, id);
        }

        public static String orderUpdateRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_UPDATE, TOKEN_ID, id);
        }

        public static String orderDeleteRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_DELETE, TOKEN_ID, id);
        }

        public static String orderDownloadsRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_DOWNLOADS, TOKEN_ID, id);
        }

        public static String orderExpireRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_EXPIRE, TOKEN_ID, id);
        }

        public static String orderSendEmailRequestUrl(final String id, final boolean resetExpiration) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_EMAIL,
                    new String[] {TOKEN_ID, TOKEN_RESET},
                    new String[] {id, resetExpiration ? "true" : "false"});
        }

        public static String orderSendEmailRequestUrl(final String id, final Date expirationDate) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_EMAIL_DATE,
                    new String[] {TOKEN_ID, TOKEN_RESET},
                    new String[] {id, DATE_FORMAT.format(expirationDate)});
        }

        public static String orderStatsRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_STATS, TOKEN_ID, id);
        }
    }


    public static final class OrderItems {

        private static final String METHOD_ORDER_ITEMS = "orders/" + TOKEN_ID + "/order_items";
        private static final String METHOD_ORDER_ITEM = "orders/" + TOKEN_ORDER_ID + "/order_items/" + TOKEN_ID;
        private static final String METHOD_ORDER_ITEM_FILES = "orders/" + TOKEN_ORDER_ID + "/order_items/" + TOKEN_ID + "/files";
        private static final String METHOD_ORDER_ITEM_DOWNLOADS = "orders/" + TOKEN_ORDER_ID + "/order_items/" + TOKEN_ID + "/downloads";
        private static final String METHOD_ORDER_ITEM_EXPIRE = "orders/" + TOKEN_ORDER_ID + "/order_items/" + TOKEN_ID + "/expire";

        public static String orderItemsRequestUrl(final String id) {
            return StringUtils.replace(METHOD_ORDER_ITEMS, TOKEN_ID, id);
        }

        public static String orderItemRequestUrl(final String orderId, final String id) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_ITEM,
                    new String[] {TOKEN_ORDER_ID, TOKEN_ID},
                    new String[] {orderId, id});
        }

        public static String orderItemFilesRequestUrl(final String orderId, final String id) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_ITEM_FILES,
                    new String[] {TOKEN_ORDER_ID, TOKEN_ID},
                    new String[] {orderId, id});
        }

        public static String orderItemDownloadsRequestUrl(final String orderId, final String id) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_ITEM_DOWNLOADS,
                    new String[] {TOKEN_ORDER_ID, TOKEN_ID},
                    new String[] {orderId, id});
        }

        public static String orderItemExpireRequestUrl(final String orderId, final String id) {
            return StringUtils.replaceEach(
                    METHOD_ORDER_ITEM_EXPIRE,
                    new String[] {TOKEN_ORDER_ID, TOKEN_ID},
                    new String[] {orderId, id});
        }
    }


    public static final class Products {

        private static final String METHOD_PRODUCT = "products/" + TOKEN_SKU;
        private static final String METHOD_PRODUCT_UPDATE = "products/" + TOKEN_SKU + "/update";
        private static final String METHOD_PRODUCT_DELETE = "products/" + TOKEN_SKU + "/delete";
        private static final String METHOD_PRODUCT_STATS = "products/" + TOKEN_SKU + "/stats";
        private static final String METHOD_PRODUCT_FILES = "products/" + TOKEN_SKU + "/files";
        private static final String METHOD_PRODUCT_DOWNLOADS = "products/" + TOKEN_SKU + "/downloads";

        public static final String METHOD_PRODUCTS = "products";
        public static final String METHOD_PRODUCT_CREATE = "products/create";

        public static String productRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT, TOKEN_SKU, sku);
        }

        public static String productUpdateRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT_UPDATE, TOKEN_SKU, sku);
        }

        public static String productDeleteRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT_DELETE, TOKEN_SKU, sku);
        }

        public static String productStatisticsRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT_STATS, TOKEN_SKU, sku);
        }

        public static String productFilesRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT_FILES, TOKEN_SKU, sku);
        }

        public static String productDownloadsRequestUrl(final String sku) {
            return StringUtils.replace(METHOD_PRODUCT_DOWNLOADS, TOKEN_SKU, sku);
        }
    }
}
