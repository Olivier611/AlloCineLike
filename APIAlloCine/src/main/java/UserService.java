import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Path("/user")
public class UserService {

	@Context
	HttpServletRequest req;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> getCinemas() {
		Database database = new Database();
		ArrayList<User> users = database.getUsers();
		database.close();
		return users;
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		Database database = new Database();
		database.addUser(user);
		return Response.status(201).entity("Done").build();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		Database database = new Database();
		boolean userCorrect = database.login(user);

		if (userCorrect) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			return Response.status(200).entity("Done").build();
			// set session
		} else {
			return Response.status(401).entity("Authentication failed").build();
		}
	}
	
	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout() {
		HttpSession session = req.getSession(true);
		session.invalidate();
		return Response.status(200).entity("Done").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id) {
		Database database = new Database();
		User user = database.getUser(id);
		database.close();
		return user;
	}
	
	
	
//	//
//	// EXEMPLE A SUPPRIMER POUR FRANCOIS !!!
//	// ICI JE FILTRE UNE ROUTE EN FONCTION DE SI LE USER EST CONNECTE OU NON
//	//
//
//	@GET
//	@Path("/testprotection")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response testprotection() {
//		HttpSession session = req.getSession(true);
//
//		if (null == session.getAttribute("user"))
//		{
//			// si user est pas connecte on renvoie erreur 401
//			return Response.status(401).entity("Authentication needed").build();
//		}
//
//		// sinon �a veut dire qu il est connecte, on peut faire des traitements ...
//		return Response.status(200).entity("Done").build();
//	}
	

}
