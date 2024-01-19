package com.examen;

public class Tache {

    private boolean complete;
    private String titre;
    private String description;
    private int duree; //admettons en jour


    public Tache(String nTitre, String nDesc, int nDuree){
        titre = nTitre;
        complete = false;
        description = nDesc;
        duree = nDuree;
    }

    public boolean getComplete(){
        return complete;
    }

    public String getTitre() {
        return titre;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return "Nom: " + titre;
    }
}
