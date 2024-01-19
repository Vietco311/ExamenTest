import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.examen.GestionTaches;
import com.examen.Projet;

public class ProjetTest {

    private static Projet projet;
    private static GestionTaches gestionTaches;

    @BeforeAll
    public static void setUp() {
        gestionTaches = new GestionTaches();
        projet = new Projet("Mon Projet", gestionTaches);
    }

    @Test
    public void testAjouterTacheAuProjet() {
        projet.ajouterTache("TacheProjet", "Description de la tache pour le projet", 2);
        assertTrue(projet.getTaches().getListe().stream().anyMatch(t -> t.getTitre().equals("TacheProjet")));
        assertFalse(gestionTaches.verifierTache("TacheProjet"));
    }

    @Test
    public void testCompleterTacheDansProjet() {
        projet.ajouterTache("TacheProjet", "Description de la tache pour le projet", 2);
        assertFalse(projet.getTaches().verifierTache("TacheProjet"));
        projet.completerTache("TacheProjet");
        assertTrue(projet.getTaches().verifierTache("TacheProjet"));
        assertTrue(gestionTaches.verifierTache("TacheProjet"));
    }

    @Test
    public void testCalculerDureeTotale(){
        projet.ajouterTache("TacheProjet1", "Description de la tache1", 2);
        projet.ajouterTache("TacheProjet2", "Description de la tache2", 4);
        projet.ajouterTache("TacheProjet3", "Description de la tache3", 1);
        assertEquals(7, projet.calculerDureeTotale());
    }

    @Test
    public void testCalculerDureeTotaleVide(){
        assertEquals(0, projet.calculerDureeTotale());
    }

    @Test
    public void testCalculerDureeTotaleNega(){
        projet.ajouterTache("TacheProjet1", "Description de la tache1", -2);
        projet.ajouterTache("TacheProjet2", "Description de la tache2", 4);
        projet.ajouterTache("TacheProjet3", "Description de la tache3", -1);
        assertEquals(4, projet.calculerDureeTotale());
    }
}
