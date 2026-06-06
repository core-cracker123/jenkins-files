package org.examples.java;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("persons")
public class PersonResource {

    @Inject
    PersonDatabase database;

    @GET
    @Produces("application/xml")
    public Person[] get() {
        return database.currentList();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Person get(@PathParam("id") int id) {
        return database.getPerson(id);
    }
}
