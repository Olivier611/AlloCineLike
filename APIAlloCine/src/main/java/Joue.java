public class Joue {
    int id;
    int id_acteur;
    int id_film;

    public Joue(int id, int id_acteur, int id_film) {
        this.id = id;
        this.id_acteur = id_acteur;
        this.id_film = id_film;
    }

    public Joue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_acteur() {
        return id_acteur;
    }

    public void setId_acteur(int id_acteur) {
        this.id_acteur = id_acteur;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }
}
