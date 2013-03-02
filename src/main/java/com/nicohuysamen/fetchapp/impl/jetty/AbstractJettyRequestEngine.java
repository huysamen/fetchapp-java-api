/*
* AbstractJettyRequestEngine.java
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

package com.nicohuysamen.fetchapp.impl.jetty;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

/**
 *
 */
public abstract class AbstractJettyRequestEngine {

    protected final HttpClient httpClient = new HttpClient();
    protected String authKey;

    protected AbstractJettyRequestEngine(
            final String authKey,
            final int maxConnectionsPerAddress,
            final int connectionQueueSize,
            final int connectionTimeout) throws Exception {

        httpClient.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
        httpClient.setMaxConnectionsPerAddress(maxConnectionsPerAddress);
        httpClient.setThreadPool(new QueuedThreadPool(connectionQueueSize));
        httpClient.setTimeout(connectionTimeout);
        httpClient.start();

        this.authKey = authKey;
    }

    public void setAuthKey(final String authKey) {
        this.authKey = authKey;
    }
}
