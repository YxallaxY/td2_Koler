import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private String nom;
    private Formation formation;
    private List<Etudient> etudiants;

    public Groupe(String nom, Formation formation) {
        this.nom = nom;
        this.formation = formation;
        this.etudiants = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Etudient> getEtudiants() {
        return etudiants;
    }

    public void ajouterEtudiant(Etudient etudiant) {
        if (etudiant.getFormation().equals(this.formation)) {
            etudiants.add(etudiant);
        } else {
            System.out.println("Erreur : L'étudiant a une formation différente de celle du groupe.");
        }
    }

    public void supprimerEtudiant(Etudient etudiant) {
        etudiants.remove(etudiant);
    }
}
