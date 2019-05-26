package com.github.inxex.example;

import io.micronaut.context.annotation.EachBean;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;

import java.net.URI;

@io.micronaut.context.annotation.Factory
public class Factory {

    @EachBean(ClientProperty.class)
    UrlSpecificLowLevelClient dataSource(ClientProperty configuration, @Client("/") HttpClient client) {
        URI url = configuration.getUrl();
        return new UrlSpecificLowLevelClient(client, url, configuration.getName());
    }
}
