import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class DepartementHashSet implements IDepartement <Departement> {

    private HashSet<Departement> set = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement d) {
        set.add(d);
    }

    @Override
    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement d : set) {
            if (d.getNomDepartement().equalsIgnoreCase(nomDepartement))
                return true;
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return set.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        set.remove(d);
    }

    @Override
    public void afficherDepartements() {
        for (Departement d : set) {
            System.out.println(d);
        }
    }

    @Override
    public void trierDepartementsParId() {
        ArrayList<Departement> liste = new ArrayList<>(set);
        Collections.sort(liste, new Comparator<Departement>() {
            @Override
            public int compare(Departement o1, Departement o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        System.out.println("---- Tri par ID ----");
        for (Departement d : liste)
            System.out.println(d);
    }

    @Override
    public void trierDepartementsParNomEtNombreEmployes() {

        ArrayList<Departement> liste = new ArrayList<>(set);

        Collections.sort(liste, new Comparator<Departement>() {
            @Override
            public int compare(Departement d1, Departement d2) {


                int cmp = d1.getNomDepartement().compareToIgnoreCase(d2.getNomDepartement());
                if (cmp != 0) return cmp;


                return Integer.compare(d1.getNombreEmployes(), d2.getNombreEmployes());
            }
        });

        System.out.println(" Tri par Nom + NombreEmployes ");
        for (Departement d : liste)
            System.out.println(d);
    }
}