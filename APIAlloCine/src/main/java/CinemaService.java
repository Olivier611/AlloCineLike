import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/cinema")
public class CinemaService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cinema> getCinemas() {
        Database database = new Database();
        ArrayList<Cinema> cinemas = database.getCinemas();
        database.close();
        return cinemas;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cinema getFilm(@PathParam("id") int id ) {
        Database database = new Database();
        Cinema cinema = database.getCinema(id);
        database.close();
        return cinema;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCinema(Cinema cinema){
        Database database = new Database();
        database.addCinema(cinema);
        return Response.status(201).entity("Done").build();
    }
}
