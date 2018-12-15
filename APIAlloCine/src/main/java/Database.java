import java.io.Console;
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
}
