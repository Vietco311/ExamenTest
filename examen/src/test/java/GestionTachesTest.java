import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.examen.GestionTaches;
import com.examen.Tache;

public class GestionTachesTest {

    private static GestionTaches gestionTaches;

    //Lance à chaque test pour assurer d'avoir de nouvelle liste de taches
    @BeforeAll
    static public void setUp() {
        gestionTaches = new GestionTaches();
    }

    //Ajout de la tâche
    @Test
    public void testAjouterTache() {
        gestionTaches.ajouterTache("Tache1", "Description de la tache 1", 2);
        assertFalse(gestionTaches.tacheExiste("Tache1"));
    }

    //Completion de la tâche
    @Test
    public void testCompleterTache() {
        gestionTaches.ajouterTache("Tache2", "Description de la tache 2", 2);
        assertFalse(gestionTaches.verifierTache("Tache2"));
        gestionTaches.completerTache("Tache2");
        assertTrue(gestionTaches.verifierTache("Tache2"));
    }

    //Vérificaton de la tâche
    @Test
    public void testCompleterTacheInexistante() {
        List<Tache> etatInitial = new ArrayList<>(gestionTaches.getListe());
        gestionTaches.completerTache("TacheInexistante");
        assertEquals(etatInitial, gestionTaches.getListe());
    }

    //Vérification pour une tâche non existante
    @Test
    public void testVerifierTacheInexistante() {
        assertFalse(gestionTaches.verifierTache("TacheInexistante"));
        assertFalse(gestionTaches.tacheExiste("TacheInexistante"));
    }

    //Vérification pour une tâche non complétée
    @Test
    public void testVerifierTacheNonCompletee() {
        gestionTaches.ajouterTache("Tache3", "Description de la tache 3", 3);
        assertFalse(gestionTaches.verifierTache("Tache3"));
    }

    //Vérification que la tâche est complétée
    @Test
    public void testVerifierTacheCompletee() {
        gestionTaches.ajouterTache("Tache4", "Description de la tache 4" , 4);
        gestionTaches.completerTache("Tache4");
        assertTrue(gestionTaches.verifierTache("Tache4"));
    }
}