public class Film {
    private int id;
    private String nom;
    private String date_sortie;
    private String acteurs_principaux;
    private String synopsis;
    private String distributeur;
    private String type;
    private String langage;

    public Film(int id, String nom, String date_sortie, String acteurs_principaux, String synopsis, String distributeur, String type, String langage) {
        this.id = id;
        this.nom = nom;
        this.date_sortie = date_sortie;
        this.acteurs_principaux = acteurs_principaux;
        this.synopsis = synopsis;
        this.distributeur = distributeur;
        this.type = type;
        this.langage = langage;
    }

    public Film(){}

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

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getActeurs_principaux() {
        return acteurs_principaux;
    }

    public void setActeurs_principaux(String acteurs_principaux) {
        this.acteurs_principaux = acteurs_principaux;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDistributeur() {
        return distributeur;
    }

    public void setDistributeur(String distributeur) {
        this.distributeur = distributeur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }
}
