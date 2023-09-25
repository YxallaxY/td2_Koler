import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private String nom;
    private Formation formation;
    private List<Etudiant> etudiants;

    public Groupe(String nom, Formation formation) {
        this.nom = nom;
        this.formation = formation;
        this.etudiants = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant.getFormation().equals(this.formation)) {
            etudiants.add(etudiant);
        } else {
            System.out.println("Erreur : L'étudiant a une formation différente de celle du groupe.");
        }
    }

    public void supprimerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }
}
