
package tn.esprit.services;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.interfaces.IAffectation;

import java.util.*;

public class AffectationHashMap implements IAffectation {

    private HashMap<Employe, Departement> affectations = new HashMap<>();

    @Override
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e)) {
            System.out.println(" L'employé " + e.getNom() + " est déjà affecté à un département !");
        } else {
            affectations.put(e, d);
            System.out.println(" Affectation ajoutée : " + e.getNom() + " → " + d.getNomDepartement());
        }
    }

    @Override
    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation trouvée.");
            return;
        }

        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            Employe e = entry.getKey();
            Departement d = entry.getValue();
            System.out.println(e.getNom() + " " + e.getPrenom() +
                    " → Département : " + d.getNomDepartement());
        }
    }

    @Override
    public void supprimerEmploye(Employe e) {
        if (affectations.remove(e) != null) {
            System.out.println(" Employé supprimé : " + e.getNom());
        } else {
            System.out.println(" Employé non trouvé : " + e.getNom());
        }
    }

    @Override
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
            System.out.println(" Affectation supprimée : " + e.getNom() + " - " + d.getNomDepartement());
        } else {
            System.out.println(" L'affectation demandée n'existe pas !");
        }
    }

    @Override
    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé trouvé.");
            return;
        }
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    @Override
    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département affecté.");
            return;
        }


        Set<Departement> uniqueDeps = new HashSet<>(affectations.values());

        for (Departement d : uniqueDeps) {
            System.out.println(d);
        }
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    @Override
    public TreeMap<Employe, Departement> trierMap() {
        System.out.println(" Map triée par ID d'employé : ");
        return new TreeMap<>(affectations);
    }
}


