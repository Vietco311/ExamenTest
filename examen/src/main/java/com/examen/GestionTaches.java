package com.examen;

import java.util.ArrayList;

public class GestionTaches {

    private ArrayList<Tache> liste = new ArrayList<>();

    public GestionTaches(){

    }

    public ArrayList<Tache> getListe() {
        return liste;
    }

    public void ajouterTache(String titre, String desc, int duree){
        liste.add(new Tache(titre, desc, duree));
    }

    public void completerTache(String t) {
        for (Tache ta : liste) {
            if (ta.getTitre().equals(t)) {
                ta.setComplete(true);
            }
        }
    }

    public boolean tacheExiste(String t){
        for (Tache ta : liste) {
            if (ta.getTitre().equals(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifierTache(String t){
        for (Tache ta : liste){
            if (ta.getTitre() == t){
                if (ta.getComplete()){
                    return true;
                }
            }
        }
        return false;
    }
}
