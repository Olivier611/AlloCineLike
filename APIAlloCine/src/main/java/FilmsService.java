import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/films")
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
}
