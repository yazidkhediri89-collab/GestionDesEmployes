public class Main {
    public static void main(String[] args) {

        SocieteArrayList s = new SocieteArrayList();

        s.ajouterEmploye(new Employe(3,"Ali","Hassen","IT",2));
        s.ajouterEmploye(new Employe(1,"Sami","Karoui","RH",1));
        s.ajouterEmploye(new Employe(2,"Nour","Ben Salem","IT",3));
        s.ajouterEmploye(new Employe(4,"Amira","Saidi","IT",2));

        System.out.println("---- Liste des employés ----");
        s.displayEmploye();

        System.out.println("\n---- Recherche par département : IT ----");
        System.out.println(s.rechercherParDepartement("IT"));

        System.out.println("\n---- Tri par ID ----");
        s.trierEmployeParId();
        s.displayEmploye();

        System.out.println("\n---- Tri par Département + Grade + Nom ----");
        s.trierEmployeParNomDépartementEtGrade();
        s.displayEmploye();
    }
}
