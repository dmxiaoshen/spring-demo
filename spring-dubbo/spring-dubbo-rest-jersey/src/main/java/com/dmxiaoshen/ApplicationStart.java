package com.dmxiaoshen;

import com.dmxiaoshen.application.Application;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

/**
 * Created by hzhsg on 2017/11/16.
 */
public class ApplicationStart {

    public static final String BASE_URI = "http://localhost:8080/";


    public static HttpServer startServer() {
        Application application = new Application();
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), application);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));

        System.in.read();
        server.shutdownNow();
    }
}
