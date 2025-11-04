import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {

    private ArrayList<Employe> liste = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        liste.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : liste) {
            if (e.getNom().equalsIgnoreCase(nom))
                return true;
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return liste.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        liste.remove(e);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : liste)
            System.out.println(e);
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(liste);
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(liste, new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int dep = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
                if(dep != 0) return dep;

                int gr = Integer.compare(e1.getGrade(), e2.getGrade());
                if(gr != 0) return gr;

                return e1.getNom().compareToIgnoreCase(e2.getNom());
            }
        });
    }

    // ✅ Méthode de la nouvelle interface
    @Override
    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> result = new ArrayList<>();
        for(Employe e : liste){
            if(e.getNomDepartement().equalsIgnoreCase(nomDepartement)){
                result.add(e);
            }
        }
        return result;
    }
}
