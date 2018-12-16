import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/film")
public class FilmsService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Film> getFilm() {
        Database database = new Database();
        ArrayList<Film> filmArrayList = database.getFilms();
        database.close();
        return filmArrayList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film getFilm(@PathParam("id") int id ) {
        Database database = new Database();
        Film film = database.getFilm(id);
        database.close();
        return film;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm(Film film){
        Database database = new Database();
        database.addFilm(film);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteFilm(@PathParam("id") int id) {
        Database database = new Database();
        database.deleteFilm(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }
}
