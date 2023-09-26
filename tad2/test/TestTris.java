import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestTris {
    private Groupe groupe;
    private Formation formation;

    @Before
    public void setUp() {
        formation = new Formation("Informatique");
        groupe = new Groupe("Groupe A", formation);
    }

    @Test
    public void testTriAlpha() {
        Etudiant etudiant1 = new Etudiant(new Identite("12345", "Dupont", "Jean"), formation);
        Etudiant etudiant2 = new Etudiant(new Identite("67890", "Smith", "Alice"), formation);
        Etudiant etudiant3 = new Etudiant(new Identite("45678", "Brown", "John"), formation);

        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant3);

        groupe.triAlpha();

        List<Etudiant> etudiantsTries = groupe.getEtudiants();
        List<String> nomsTries = new ArrayList<>();
        for (Etudiant etudiant : etudiantsTries) {
            nomsTries.add(etudiant.getIdentite().getNom());
        }

        List<String> nomsAttendus = List.of("Brown", "Dupont", "Smith");
        assertEquals(nomsAttendus, nomsTries);
    }

    @Test
    public void testTriAntiAlpha() {
        Etudiant etudiant1 = new Etudiant(new Identite("12345", "Dupont", "Jean"), formation);
        Etudiant etudiant2 = new Etudiant(new Identite("67890", "Smith", "Alice"), formation);
        Etudiant etudiant3 = new Etudiant(new Identite("45678", "Brown", "John"), formation);

        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant3);

        groupe.triAntiAlpha();

        List<Etudiant> etudiantsTries = groupe.getEtudiants();
        List<String> nomsTries = new ArrayList<>();
        for (Etudiant etudiant : etudiantsTries) {
            nomsTries.add(etudiant.getIdentite().getNom());
        }

        List<String> nomsAttendus = List.of("Smith", "Dupont", "Brown");
        assertEquals(nomsAttendus, nomsTries);
    }
}
