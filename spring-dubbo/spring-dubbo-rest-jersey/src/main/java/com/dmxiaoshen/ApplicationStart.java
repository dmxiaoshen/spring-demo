package com.dmxiaoshen;

import com.dmxiaoshen.entity.Book;
import com.dmxiaoshen.service.BookService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;

/**
 * Created by hzhsg on 2017/11/16.
 */
public class ApplicationStart {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and
        // providers
        // in com.tairanchina.passport package
        final ResourceConfig rc = new ResourceConfig().packages("com.dmxiaoshen.resource");
        // rc.packages("com.xxx.filter");

        rc.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        rc.property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        try {
            // 拉取dubbo服务
            new DubboContext("dubbo-rest", "zookeeper://dmxiaoshen.zk.com:2888").start();
            BookService bookService = ApiHolder.getBean(BookService.class);
            Book book = new Book();
            book.setId("1");
            book.setName("java编程技术");
            book.setPrice(new BigDecimal("33.6"));
            book.setDescription("一本好书");
            bookService.addBook(book);
//            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:rest-context.xml");
//            context.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));

        System.in.read();
        server.shutdownNow();
    }
}
