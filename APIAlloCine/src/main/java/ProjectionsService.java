import com.sun.istack.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/projection")
public class ProjectionsService {
    @Context
    HttpServletRequest req;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Projections> getProjection(
            @Nullable @QueryParam ("ville") String ville,
            @Nullable @QueryParam ("cinema") String cinema) {
        Database database = new Database();
        ArrayList<Projections> projections = database.getProjections();
        if (ville!=null){
            ArrayList<Projections> tmp = new ArrayList<Projections>();
            for (Projections projection:projections) {
                if (database.getCinema(projection.getId_cinema()).getAdresse().getVille().equals(ville))
                    tmp.add(projection);
            }
            projections = tmp;
        }
        if (cinema!=null){
            ArrayList<Projections> tmp = new ArrayList<Projections>();
            for (Projections projection:projections) {
                if (database.getCinema(projection.getId_cinema()).getNom().equals(cinema))
                    tmp.add(projection);
            }
            projections = tmp;
        }
        database.close();

        return projections;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Projections getProjection(@PathParam("id") int id ) {
        Database database = new Database();
        Projections projection = database.getProjection(id);
        database.close();
        return projection;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm(Projections projections){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.addProjection(projections);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteProjection(@PathParam("id") int id) {
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.deleteProjection(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilm(@PathParam("id") int id, Projections projections){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }

        Database database = new Database();
        database.updateProjection(id,projections);
        database.close();
        projections.setId(id);
        return Response.ok().entity(projections).build();
    }
}
