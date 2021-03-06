package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class TestVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("TEST HTTP server started on port 8888   -2");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}

