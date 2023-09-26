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
}
