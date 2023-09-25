import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EtudiantTest {
    private Etudiant etudiant;
    private Formation formation;

    @Before
    public void setUp() {
        formation = new Formation("Informatique");
        formation.ajouterMatiere("Mathématiques", 3);
        formation.ajouterMatiere("Informatique", 4);
        etudiant = new Etudiant(new Identite("12345", "Dupont", "Jean"), formation);
    }

    @Test
    public void testAjouterNote() {
        etudiant.ajouterNote("Mathématiques", 15.5);
        assertTrue(etudiant.getNotes().containsKey("Mathématiques"));
    }

    @Test
    public void testCalculerMoyenneMatiere() {
        etudiant.ajouterNote("Mathématiques", 15.5);
        double moyenne = etudiant.calculerMoyenneMatiere("Mathématiques");
        assertEquals(15.5, moyenne, 0.01); // Utilisation d'une tolérance de 0.01 pour la comparaison des doubles
    }

    @Test
    public void testCalculerMoyenneGenerale() {
        etudiant.ajouterNote("Mathématiques", 15.5);
        etudiant.ajouterNote("Informatique", 18.0);
        double moyenneGenerale = etudiant.calculerMoyenneGenerale();
        assertEquals(16.9, moyenneGenerale, 0.01); // Utilisation d'une tolérance de 0.01 pour la comparaison des doubles
    }

    @Test
    public void testCalculerMoyenneGeneraleAvecFormationVide() {
        double moyenneGenerale = etudiant.calculerMoyenneGenerale();
        assertEquals(0.0, moyenneGenerale, 0.01); // Lorsque la formation est vide, la moyenne doit être 0
    }

    @Test
    public void testGetFormation() {
        Formation formationEtudiant = etudiant.getFormation();
        assertEquals("Informatique", formationEtudiant.getIdentifiant());
    }
}
