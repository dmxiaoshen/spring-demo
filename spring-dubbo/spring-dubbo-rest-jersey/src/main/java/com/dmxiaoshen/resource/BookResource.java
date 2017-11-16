package com.dmxiaoshen.resource;

import com.dmxiaoshen.ApiHolder;
import com.dmxiaoshen.entity.Book;
import com.dmxiaoshen.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by hzhsg on 2017/11/16.
 */
@Path("book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book){
        ApiHolder.getBean(BookService.class).addBook(book);
        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity("{\"status\":\"success\"}").build();
    }

    @GET
    @Path("/get")
    public Response getBook(@QueryParam("id")String id) throws JsonProcessingException {
        BookService bookService = ApiHolder.getBean(BookService.class);
        Book book = bookService.getBookById(id);
        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(new ObjectMapper().writeValueAsString(book)).build();
    }
}
