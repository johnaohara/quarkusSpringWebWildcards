package io.quarkus.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/resteasy")
public class RestEasyResource {

    @GET
    @Path("/hello")
    public String hello(){
        return "hello";
    }

    @GET
    @Path("/wildcard/*/{name}")
    public String hello(@PathParam("name") String name){
        return "hello " + name;
    }

    @GET
    @Path("/pattern/{id : .*}/{name}")
    public String patternHello(@PathParam("name") String name){
        return "hello " + name;
    }

    @GET
    @Path("pathA/{var:.+}/pathZ")
    public String test(@PathParam("var") String path){
        return path;
    }
}
