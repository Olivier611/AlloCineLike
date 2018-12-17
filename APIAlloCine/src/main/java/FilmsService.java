import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/films")
public class FilmsService {
    @Context
    HttpServletRequest req;

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
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm(Film film){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.addFilm(film);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFilm(@PathParam("id") int id) {
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.deleteFilm(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilm(@PathParam("id") int id, Film film){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.updateFilm(id,film);
        database.close();
        film.setId(id);
        return Response.ok().entity(film).build();
    }
}
