public class Cinema {
    int id;
    String nom;
    Adresse adresse;
    int nombre_salle;

    public Cinema(int id, String nom, Adresse adresse, int nombre_salle) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nombre_salle=nombre_salle;
    }

    public Cinema(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNombre_salle() {
        return nombre_salle;
    }

    public void setNombre_salle(int nombre_salle) {
        this.nombre_salle = nombre_salle;
    }
}
