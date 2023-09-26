import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
                count+=1;
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

    public void triAlpha() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                return etudiant1.getIdentite().getNom().compareTo(etudiant2.getIdentite().getNom());
            }
        });
    }

    public void triAntiAlpha() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                return etudiant2.getIdentite().getNom().compareTo(etudiant1.getIdentite().getNom());
            }
        });
    }

    public void triParMerite() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                double moyenne1 = etudiant1.calculerMoyenneGenerale();
                double moyenne2 = etudiant2.calculerMoyenneGenerale();

                // Trie par ordre décroissant (du meilleur au moins bon)
                return Double.compare(moyenne2, moyenne1);
            }
        });
    }

}
