package com.examen;

import java.util.ArrayList;

public class Projet {

    private String nom;
    private GestionTaches taches;

    public Projet(String nNom, GestionTaches nTaches){
        nom = nNom;
        taches = nTaches;
    }

    public GestionTaches getTaches() {
        return taches;
    }

    public void completerTache(String titre){
        taches.completerTache(titre);
    }

    public void ajouterTache(String titre, String desc, int duree){
        taches.ajouterTache(titre, desc, duree);
    }

    public int calculerDureeTotale(){
        int duree = 0;
        for(Tache tache : taches.getListe()){
            if(tache.getDuree() >= 0){
                duree += tache.getDuree();
            }          
        }
        return duree;
    }
}
