package at.htl.restprimer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Path("time")
public class TimeServiceResource {
    @GET
    public String time(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("%D"));
    }
}
