/*
 * Created by norman on 29.05.15.
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * REST Service.
 */
@Path("/hello")
public class HelloRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello REST";
    }
}
