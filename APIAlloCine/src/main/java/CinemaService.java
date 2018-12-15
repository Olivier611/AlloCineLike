import com.sun.istack.Nullable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/cinema")
public class CinemaService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cinema> getCinemas(@Nullable @QueryParam ("ville") String ville) {
        Database database = new Database();
        ArrayList<Cinema> cinemas = database.getCinemas();
        database.close();
        if (ville!=null){
            ArrayList<Cinema> newList= new ArrayList<Cinema>();
            for (int i =0;i<cinemas.size();i++){
                if (cinemas.get(i).getAdresse().ville.equals(ville))
                    newList.add(cinemas.get(i));
            }
            return newList;
        }
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
