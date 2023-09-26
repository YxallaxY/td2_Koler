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

    public double calculerMoyenneMatiere(String matiere) {
        double somme = 0;
        int count = 0;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNotes().containsKey(matiere)) {
                somme += etudiant.getNotes().get(matiere);
                count++;
            }
        }
        return (count > 0) ? somme / count : 0.0;
    }

    public double calculerMoyenneGenerale() {
        double somme = 0;
        int count = 0;
        for (Etudiant etudiant : etudiants) {
            double moyenneEtudiant = etudiant.calculerMoyenneGenerale();
            if (moyenneEtudiant > 0) {
                somme += moyenneEtudiant;
                count++;
            }
        }
        return (count > 0) ? somme / count : 0.0;
    }

}
