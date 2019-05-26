package com.github.index.example;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;

import java.net.URI;
import java.net.URISyntaxException;

@EachProperty("client.property")
public class ClientProperty {
    private final String name;
    private URI url;

    public ClientProperty(@Parameter String name)
            throws URISyntaxException {
        this.name = name;
    }

    String getName() {
        return name;
    }

    URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }
}
