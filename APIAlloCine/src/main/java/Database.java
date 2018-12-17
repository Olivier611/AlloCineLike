import javax.ws.rs.Produces;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;

    Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://***REMOVED***:3306/francois","francois","***REMOVED***");
        } catch (SQLException e) {
            System.out.println("FRANCOIS  : SQLException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("FRANCOIS  : ClassNotFoundException");
            e.printStackTrace();
        }
        System.out.println("FRANCOIS  : "+connection.toString());

    }

    void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Film> getFilms(){
        ArrayList<Film> filmArrayList = new ArrayList<Film>();
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from films");
            while(rs.next())
                filmArrayList.add(new Film(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmArrayList;
    }

    Film getFilm(String name){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from films where nom = '"+name+"'");
            return new Film(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    Film getFilm(int id){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from films where id = '"+id+"'");
            if (rs.next())
                return new Film(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void addFilm(Film film){

        PreparedStatement ps = null;
        String INSERT_SQL = "INSERT into films(nom, date_sortie, acteurs_principaux, synopsis, distributeur, type, langue) values ( ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = this.connection.prepareStatement(INSERT_SQL);
            ps.setString(1, film.getNom());
            ps.setString(2, film.getDate_sortie());
            ps.setString(3, film.getActeurs_principaux());
            ps.setString(4, film.getSynopsis());  // You'll have to update this each and every year. BirthDate would be better.
            ps.setString(5, film.getDistributeur());
            ps.setString(6, film.getType());
            ps.setString(7, film.getLangage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void deleteFilm(int id){
        PreparedStatement ps = null;
        String DELETE_SQL = "DELETE from films where id = ?";

        try {
            ps = this.connection.prepareStatement(DELETE_SQL);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void updateFilm(int id, Film film){
        PreparedStatement ps = null;
        String UPDATE_SQL = "UPDATE films SET nom=?,date_sortie=?,acteurs_principaux=?,synopsis=?,distributeur=?,type=?,langue=? where id = ?";
        try {
            ps = this.connection.prepareStatement(UPDATE_SQL);
            ps.setString(1,film.getNom());
            ps.setString(2,film.getDate_sortie());
            ps.setString(3,film.getActeurs_principaux());
            ps.setString(4,film.getSynopsis());
            ps.setString(5,film.getDistributeur());
            ps.setString(6,film.getType());
            ps.setString(7,film.getLangage());
            ps.setInt(8,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    ArrayList<Cinema> getCinemas(){
        ArrayList<Cinema> cinemaArrayList = new ArrayList<Cinema>();
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from cinemas");
            while(rs.next())
                cinemaArrayList.add(new Cinema(rs.getInt(1),rs.getString(2), Serializer.deserialize(rs.getString(3)),rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cinemaArrayList;
    }

    Cinema getCinema(int id){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from cinemas where id = '"+id+"'");
            if (rs.next())
                return new Cinema(rs.getInt(1),rs.getString(2), Serializer.deserialize(rs.getString(3)),rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void addCinema(Cinema cinema){
        PreparedStatement ps = null;
        String INSERT_SQL = "INSERT into cinemas(nom, adresse, nombre_salles) values ( ?, ?, ?)";

        try {
            ps = this.connection.prepareStatement(INSERT_SQL);
            ps.setString(1, cinema.getNom());
            ps.setString(2, Serializer.serialize(cinema.getAdresse()));
            ps.setInt(3, cinema.getNombre_salle());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void deleteCinema(int id){
        PreparedStatement ps = null;
        String DELETE_SQL = "DELETE from cinemas where id = ?";

        try {
            ps = this.connection.prepareStatement(DELETE_SQL);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void updateCinema(int id, Cinema cinema){
        PreparedStatement ps = null;
        String UPDATE_SQL = "UPDATE cinemas SET nom=?, adresse=?, nombre_salles=? where id=?";

        try {
            ps = this.connection.prepareStatement(UPDATE_SQL);
            ps.setString(1, cinema.getNom());
            ps.setString(2, Serializer.serialize(cinema.getAdresse()));
            ps.setInt(3, cinema.getNombre_salle());
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    ArrayList<User> getUsers(){
        ArrayList<User> userArrayList = new ArrayList<User>();
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
                userArrayList.add(new User(rs.getString(1),rs.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    void addUser(User user){
        PreparedStatement ps = null;
        String INSERT_SQL = "INSERT into users(login, password) values (?, ?)";

        try {
            ps = this.connection.prepareStatement(INSERT_SQL);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    User getUser(int id){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users where id = '"+id+"'");
            if (rs.next())
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    boolean login(User user){
        PreparedStatement ps = null;
        String INSERT_SQL = "select * from users where login = ? AND password =  ?";

        try {
            ps = this.connection.prepareStatement(INSERT_SQL);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.execute();
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst() ) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    ArrayList<Projections> getProjections(){
        ArrayList<Projections> projections = new ArrayList<Projections>();
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from projections");
            while(rs.next())
                projections.add(new Projections(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5), Serializer.deserializeListSeance(rs.getString(6))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projections;
    }

    Projections getProjection(int id){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from projections where id = '"+id+"'");
            if(rs.next())
                return new Projections(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5), Serializer.deserializeListSeance(rs.getString(6)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void addProjection(Projections projections){
        PreparedStatement ps = null;
        String INSERT_SQL = "INSERT into projections(id_cinema, id_film, date_debut, date_fin, seances) values ( ?, ?, ?, ?, ?)";

        try {
            ps = this.connection.prepareStatement(INSERT_SQL);
            ps.setInt(1, projections.getId_cinema());
            ps.setInt(2, projections.getId_film());
            ps.setString(3,projections.getDate_debut());
            ps.setString(4,projections.getDate_fin());
            ps.setString(5, Serializer.serialize(projections.getSeances()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void deleteProjection(int id){
        PreparedStatement ps = null;
        String DELETE_SQL = "DELETE from projections where id = ?";

        try {
            ps = this.connection.prepareStatement(DELETE_SQL);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }

    void updateProjection(int id, Projections projections){
        PreparedStatement ps = null;
        String UPDATE_SQL = "UPDATE projections SET id_cinema=?, id_film=?, date_debut=?, date_fin=?, seances=? where id=?";

        try {
            ps = this.connection.prepareStatement(UPDATE_SQL);
            ps.setInt(1, projections.getId_cinema());
            ps.setInt(2, projections.getId_film());
            ps.setString(3,projections.getDate_debut());
            ps.setString(4,projections.getDate_fin());
            ps.setString(5, Serializer.serialize(projections.getSeances()));
            ps.setInt(6,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
    }
}
