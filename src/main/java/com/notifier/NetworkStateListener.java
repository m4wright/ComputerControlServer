package com.notifier;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

public class NetworkStateListener implements StateListener
{
    private final String endpoint;

    public NetworkStateListener(String endpoint)
    {
        this.endpoint = endpoint;
    }


    @Override
    public void notifyListener(String message)
    {
        CompletableFuture.runAsync(() -> {
            try {
                URIBuilder builder = new URIBuilder(endpoint);
                builder.setParameter("message", message);
                HttpGet request = new HttpGet(builder.build());
                HttpClient client = HttpClientBuilder.create().build();
                client.execute(request);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                // TODO: unregister from controller
            }
        });
    }

    @Override
    public String getLocation()
    {
        return endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkStateListener that = (NetworkStateListener) o;

        return endpoint.equals(that.endpoint);
    }

    @Override
    public int hashCode() {
        return endpoint.hashCode();
    }
}
