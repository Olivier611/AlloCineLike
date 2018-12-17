import com.sun.istack.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/cinemas")
public class CinemaService {
    @Context
    HttpServletRequest req;

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
                if (cinemas.get(i).getAdresse().getVille().equals(ville))
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
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCinema(Cinema cinema){

        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.addCinema(cinema);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCinema(@PathParam("id") int id) {
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.deleteCinema(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilm(@PathParam("id") int id, Cinema cinema){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.updateCinema(id,cinema);
        database.close();
        cinema.setId(id);
        return Response.ok().entity(cinema).build();
    }
}
