package org.acme;

import java.security.Principal;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting")
    String greeting;

    @ConfigProperty(name = "greeting.test.new")
    String newGreeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return newGreeting;
    }

    @GET
    @Path("/whoami")
    @Produces(MediaType.TEXT_PLAIN)
    public String whoAmI(@Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        if (principal != null) {
            return principal.getName();
        } else {
            return "anonymous";
        }
    }
}
