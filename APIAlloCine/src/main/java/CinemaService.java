import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
