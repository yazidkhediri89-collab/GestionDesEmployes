public class Employe implements Comparable<Employe> {

    private int id;
    private String nom;
    private String prenom;
    private String nomDepartement;
    private int grade;

    // Constructeur sans paramètre
    public Employe() {}

    // Constructeur paramétré
    public Employe(int id, String nom, String prenom, String nomDepartement, int grade) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomDepartement = nomDepartement;
        this.grade = grade;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    // Redéfinition de equals() -> id + nom
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id == employe.id && nom.equalsIgnoreCase(employe.nom);
    }

    // hashCode cohérent avec equals
    @Override
    public int hashCode() {
        return id + nom.toLowerCase().hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", grade=" + grade +
                '}';
    }

    // compareTo -> Tri naturel par id
    @Override
    public int compareTo(Employe e) {
        return Integer.compare(this.id, e.id);
    }
}
