import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/personnes")
public class PersonneService {
    @Context
    HttpServletRequest req;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Personne> getPersonne() {
        Database database = new Database();
        ArrayList<Personne> personneArrayList = database.getPersonne();
        database.close();
        return personneArrayList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne getPersonne(@PathParam("id") int id ) {
        Database database = new Database();
        Personne personne = database.getPersonne(id);
        database.close();
        return personne;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPersonne(Personne personne){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.addPersonne(personne);
        return Response.status(201).entity("Done").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePersonne(@PathParam("id") int id) {
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.deletePersonne(id);
        database.close();
        return Response.status(201).entity("Done").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersonne(@PathParam("id") int id, Personne personne){
        HttpSession session = req.getSession(true);

        if (null == session.getAttribute("user"))
        {
            // si user est pas connecte on renvoie erreur 401
            return Response.status(401).entity("Authentication needed").build();
        }
        Database database = new Database();
        database.updatePersonne(id,personne);
        database.close();
        personne.setId(id);
        return Response.ok().entity(personne).build();
    }
}


