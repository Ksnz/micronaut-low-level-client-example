package hello.world;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import reactor.core.publisher.Flux;

import java.net.URI;

class UrlSpecificLowLevelClient {

    private final HttpClient justHttpClient;
    private final URI uri;
    private String tenantId;

    UrlSpecificLowLevelClient(HttpClient justHttpClient, URI uri, String tenantId) {
        this.justHttpClient = justHttpClient;
        this.uri = uri;
        this.tenantId = tenantId;
    }

    Flux<String> fetchPage() {
        HttpRequest<?> req = HttpRequest.GET(uri);
        return Flux.from(justHttpClient.retrieve(req)).map(s -> tenantId + ":" + s);
    }
}