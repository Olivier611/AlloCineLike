public class Personne {
    private int id;
    private String prenom;
    private String nom;
    private String date_naissance;
    private String biographie;

    public Personne(int id, String prenom, String nom, String biographie,String date_naissance) {
        this.id=id;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.biographie = biographie;
    }

    public Personne(){}

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
