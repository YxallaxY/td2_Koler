import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Formation {
    private String identifiant;
    private Map<String, Integer> matieres; // Stocker les matières avec leurs coefficients

    public Formation(String identifiant) {
        this.identifiant = identifiant;
        this.matieres = new HashMap<>();
    }

    public void ajouterMatiere(String matiere, int coefficient) {
        matieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(String matiere) {
        matieres.remove(matiere);
    }

    public boolean contientMatiere(String matiere) {
        return matieres.containsKey(matiere);
    }

    public int getCoefficient(String matiere) {
        if (contientMatiere(matiere)) {
            return matieres.get(matiere);
        } else {
            throw new IllegalArgumentException("Matière non trouvée dans la formation.");
        }
    }


    public Set<String> getMatieres() {
        return matieres.keySet();
    }
}
