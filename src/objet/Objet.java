package objet;

import vaisseau.Vaisseau;

import java.io.Serializable;

public class Objet implements utilisation, Serializable {

    protected int bonus;
    protected String nom;

    public String getNom() {
        return nom;
    }
    public void utiliser(Vaisseau vaisseau){
    }

}
