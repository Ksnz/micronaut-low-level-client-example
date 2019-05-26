package com.github.index.example;

import io.micronaut.context.annotation.Context;
import io.micronaut.scheduling.annotation.Scheduled;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import javax.inject.Inject;
import java.util.Set;

@Context
public class DoWorkService {
    @Inject
    Set<UrlSpecificLowLevelClient> set;

    @Scheduled(fixedRate = "4s")
    void doWork() {
        Flux.fromIterable(set)
                .flatMap(UrlSpecificLowLevelClient::fetchPage)
                .subscribeOn(Schedulers.elastic())
                .map(s -> s.substring(0, 64))
                .subscribe(System.out::println);
    }
}
