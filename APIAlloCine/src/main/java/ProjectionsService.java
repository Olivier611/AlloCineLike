import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/projection")
public class ProjectionsService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Projections> getSeances() {
        Database database = new Database();
        ArrayList<Projections> projections = database.getProjections();
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
        Database database = new Database();
        database.addProjection(projections);
        return Response.status(201).entity("Done").build();
    }
}
