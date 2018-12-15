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
            ps.setString(1, film.nom);
            ps.setString(2, film.date_sortie);
            ps.setString(3, film.acteurs_principaux);
            ps.setString(4, film.synopsis);  // You'll have to update this each and every year. BirthDate would be better.
            ps.setString(5, film.distributeur);
            ps.setString(6, film.type);
            ps.setString(7, film.langage);
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
            ps.setString(1, cinema.nom);
            ps.setString(2, Serializer.serialize(cinema.adresse));
            ps.setInt(3, cinema.nombre_salle);
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
}
