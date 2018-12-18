import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/joue")
public class JoueService {
    @Context
    HttpServletRequest req;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Joue> getJoue() {
        Database database = new Database();
        ArrayList<Joue> joueArrayList = database.getJoue();
        database.close();
        return joueArrayList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Joue getJoue(@PathParam("id") int id ) {
        Database database = new Database();
        Joue joue = database.getJoue(id);
        database.close();
        return joue;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addJoue(Joue joue){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.addJoue(joue);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteJoue(@PathParam("id") int id) {
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.deleteJoue(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateJoue(@PathParam("id") int id, Joue joue){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.updateJoue(id,joue);
        database.close();
        joue.setId(id);
        return Response.ok().entity(joue).build();
    }
}
