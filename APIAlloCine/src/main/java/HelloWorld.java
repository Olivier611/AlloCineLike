import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        List<Seance> seances = new ArrayList<Seance>();
        seances.add(new Seance("Lundi","10:00"));
        seances.add(new Seance("Mardi","10:00"));
        seances.add(new Seance("Mercredi","10:00"));
//        Projections projections =new Projections(1,1,1,"12/02/2018","18/10/2018",seances);
        return Serializer.serialize(seances);
    }
}
