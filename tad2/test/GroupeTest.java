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
    public void testTriParMerite() {
        Etudiant etudiant1 = new Etudiant(new Identite("12345", "Dupont", "Jean"), formation);
        Etudiant etudiant2 = new Etudiant(new Identite("67890", "Smith", "Alice"), formation);
        Etudiant etudiant3 = new Etudiant(new Identite("45678", "Brown", "John"), formation);

        etudiant1.ajouterNote("Mathématiques", 15.5);
        etudiant2.ajouterNote("Mathématiques", 18.0);
        etudiant3.ajouterNote("Mathématiques", 16.0);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);

        groupe.triParMerite();

        List<Etudiant> etudiantsTries = groupe.getEtudiants();

        // Les étudiants doivent être triés par mérite (moyenne générale décroissante)
        assertEquals(etudiant2, etudiantsTries.get(0)); // Meilleure moyenne
        assertEquals(etudiant3, etudiantsTries.get(1)); // Deuxième meilleure moyenne
        assertEquals(etudiant1, etudiantsTries.get(2)); // Moins bonne moyenne
    }

}
