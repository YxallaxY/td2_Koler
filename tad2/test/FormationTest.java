import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FormationTest {
    private Formation formation;

    @Before
    public void setUp() {
        formation = new Formation("Informatique");
    }

    @Test
    public void testAjouterMatiere() {
        formation.ajouterMatiere("Mathématiques", 3);
        assertTrue(formation.contientMatiere("Mathématiques"));
    }

    @Test
    public void testSupprimerMatiere() {
        formation.ajouterMatiere("Mathématiques", 3);
        formation.supprimerMatiere("Mathématiques");
        assertFalse(formation.contientMatiere("Mathématiques"));
    }

    @Test
    public void testGetCoefficient() {
        formation.ajouterMatiere("Mathématiques", 3);
        int coefficient = formation.getCoefficient("Mathématiques");
        assertEquals(3, coefficient);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCoefficientMatiereInexistante() {
        int coefficient = formation.getCoefficient("Physique");
    }
}
