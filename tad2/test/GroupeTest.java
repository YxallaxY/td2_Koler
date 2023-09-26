import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroupeTest {
    private Groupe groupe;
    private Formation formation;
    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @Before
    public void setUp() {
        formation = new Formation("Informatique");
        groupe = new Groupe("Groupe A", formation);
        etudiant1 = new Etudiant(new Identite("12345", "Dupont", "Jean"), formation);
        etudiant2 = new Etudiant(new Identite("67890", "Smith", "Alice"), formation);
    }

    @Test
    public void testAjouterEtudient() {
        groupe.ajouterEtudiant(etudiant1);
        assertEquals(1, groupe.getEtudiants().size());
    }

    @Test
    public void testSupprimerEtudiant() {
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.supprimerEtudiant(etudiant1);
        assertEquals(1, groupe.getEtudiants().size());
    }

    @Test
    public void testAjouterEtudiantAvecFormationDifferente() {
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        assertEquals(1, groupe.getEtudiants().size());
    }

    @Test
    public void testCalculerMoyenneMatiere() {
        etudiant1.ajouterNote("Mathématiques", 15.5);
        etudiant2.ajouterNote("Mathématiques", 18.0);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        double moyenneMatiere = groupe.calculerMoyenneMatiere("Mathématiques");
        assertEquals(16.75, moyenneMatiere, 0.01); // Utilisation d'une tolérance de 0.01 pour la comparaison des doubles
    }

    @Test
    public void testCalculerMoyenneGenerale() {
        etudiant1.ajouterNote("Mathématiques", 15.5);
        etudiant1.ajouterNote("Informatique", 18.0);
        etudiant2.ajouterNote("Mathématiques", 18.0);
        etudiant2.ajouterNote("Informatique", 16.0);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);

        double moyenneGenerale = groupe.calculerMoyenneGenerale();
        assertEquals(16.625, moyenneGenerale, 0.01); // Utilisation d'une tolérance de 0.01 pour la comparaison des doubles
    }

    @Test
    public void testCalculerMoyenneMatiereAvecAucunEtudiant() {
        double moyenneMatiere = groupe.calculerMoyenneMatiere("Mathématiques");
        assertEquals(0.0, moyenneMatiere, 0.01); // Lorsque le groupe n'a aucun étudiant, la moyenne doit être 0
    }

    @Test
    public void testCalculerMoyenneGeneraleAvecAucunEtudiant() {
        double moyenneGenerale = groupe.calculerMoyenneGenerale();
        assertEquals(0.0, moyenneGenerale, 0.01); // Lorsque le groupe n'a aucun étudiant, la moyenne doit être 0
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
