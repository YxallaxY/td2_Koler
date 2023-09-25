import java.util.HashMap;
import java.util.Map;

class Etudiant {
    private Identite identite;
    private Formation formation;
    private Map<String, Double> notes; // Utilisation d'une Map pour stocker les notes par matière

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public void ajouterNote(String matiere, double note) {
        if (formation.contientMatiere(matiere) && note >= 0 && note <= 20) {
            notes.put(matiere, note);
        } else {
            System.out.println("Erreur : Matière non autorisée ou note invalide");
        }
    }

    public double calculerMoyenneMatiere(String matiere) {
        if (notes.containsKey(matiere)) {
            return notes.get(matiere);
        } else {
            System.out.println("Erreur : Matière non trouvée");
            return 0.0; // Vous pouvez choisir de renvoyer une valeur par défaut ici
        }
    }

    public double calculerMoyenneGenerale() {
        double totalPoints = 0;
        double totalCoefficients = 0;
        for (String matiere : formation.getMatieres()) {
            if (notes.containsKey(matiere)) {
                totalPoints += notes.get(matiere) * formation.getCoefficient(matiere);
                totalCoefficients += formation.getCoefficient(matiere);
            }
        }
        if (totalCoefficients == 0) {
            return 0.0; // Éviter la division par zéro
        }
        return totalPoints / totalCoefficients;
    }

    public Formation getFormation(){
        return this.formation;
    }

    public Map<String, Double> getNotes() {
        return notes;
    }
}