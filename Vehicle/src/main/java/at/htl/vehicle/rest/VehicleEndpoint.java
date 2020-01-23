package at.htl.vehicle.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("vehicle")
public class VehicleEndpoint {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle find(@PathParam("id") long id) {
        return new Vehicle("Opel " + id,"Commodore");
    }

    @GET
    public List<Vehicle> findAll() {
        List<Vehicle> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }
}
