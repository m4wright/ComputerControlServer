package com.notifier;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NetworkStateListener implements StateListener
{
    private final String endpoint;
    private static final long timeoutInMS = 1000;

    public NetworkStateListener(String endpoint)
    {
        this.endpoint = endpoint;
    }


    @Override
    public void notifyListener(String message)
    {
        try
        {
            CompletableFuture.runAsync(() -> {
                try
                {
                    URIBuilder builder = new URIBuilder(endpoint);
                    builder.setParameter("message", message);
                    HttpGet request = new HttpGet(builder.build());
                    HttpClient client = HttpClientBuilder.create().build();
                    client.execute(request);
                }
                catch (IOException | URISyntaxException e)
                {
                    Controller.instance().removeListener(this);
                }
            }).get(timeoutInMS, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (TimeoutException e)
        {
            Controller.instance().removeListener(this);
        }
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

    @Override
    public String toString()
    {
        return endpoint;
    }
}
