import java.util.List;

public class Projections {
    private int id;
    private int id_cinema;
    private int id_film;
    private String date_debut;
    private String date_fin;
    private List<Seance> seances;

    public Projections(int id, int id_cinema, int id_film, String date_debut, String date_fin, List<Seance> seances) {
        this.id = id;
        this.id_cinema = id_cinema;
        this.id_film = id_film;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.seances = seances;
    }

    public Projections(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cinema() {
        return id_cinema;
    }

    public void setId_cinema(int id_cinema) {
        this.id_cinema = id_cinema;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
