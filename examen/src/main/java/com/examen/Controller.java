package com.examen;

import java.util.ArrayList;

public class Controller {

    private ArrayList<Tache> taches;

    public Controller(ArrayList<Tache> nTaches){
        taches = nTaches;
    }

    public String afficherTaches(){
        String chaineTaches = "";
        for(Tache tache : taches){
            chaineTaches += tache.getTitre() + "\n";
        }
        return chaineTaches;
    }
}
