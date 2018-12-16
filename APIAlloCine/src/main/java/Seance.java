public class Seance {
    private String jour;
    private String heure;

    public Seance(String jour, String heure) {
        this.jour = jour;
        this.heure = heure;
    }

    public Seance(){}

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
