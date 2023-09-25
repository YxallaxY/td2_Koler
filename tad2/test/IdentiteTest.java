import org.junit.Test;
import static org.junit.Assert.*;

public class IdentiteTest {

    @Test
    public void testConstructeurIdentite() {
        String nip = "123456";
        String nom = "Dupont";
        String prenom = "Jean";

        Identite identite = new Identite(nip, nom, prenom);

        assertEquals(nip, identite.getNip());
        assertEquals(nom, identite.getNom());
        assertEquals(prenom, identite.getPrenom());
    }
}
