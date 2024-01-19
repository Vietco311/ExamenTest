import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.examen.Controller;
import com.examen.GestionTaches;
import com.examen.Projet;

public class ControllerTest {

    private static GestionTaches gestionTaches;
    private static Projet projet;
    private static Controller controller;
    
    @BeforeAll
    public static void setUp(){
        gestionTaches = new GestionTaches();
        projet = new Projet("Mon Projet", gestionTaches);
        controller = new Controller(projet.getTaches().getListe());
    }

    @Test
    public void testAfficherTaches(){
        projet.ajouterTache("Tache1", "Description1", 1);
        projet.ajouterTache("Tache2", "Description2", 2);
        projet.ajouterTache("Tache3", "Description3", 3);
        assertEquals("Tache1\nTache2\nTache3\n", controller.afficherTaches());
    }

    @Test
    public void testAfficherTachesErreur(){
        projet.ajouterTache("Tache1", "Description1", 1);
        projet.ajouterTache("Tache2", "Description2", 2);
        projet.ajouterTache("Tache4", "Description3", 3);
        assertNotEquals("Tache1\nTache2\nTache3\n", controller.afficherTaches());
    }
}
