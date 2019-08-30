package planete;

import objet.Objet;
import vaisseau.Vaisseau;

import java.io.Serializable;
import java.util.Random;

public class Planete implements Serializable {

    protected String nom;
    protected Objet bonus;


    public Vaisseau explorer(Vaisseau vaisseau) {
        Random random = new Random();
        vaisseau.setCarburant(vaisseau.getCarburant() - (random.nextInt(10) + 5));
        if (random.nextInt(3) == 1) {
            System.out.println("Vous avez trouvé " + bonus.getNom());
            vaisseau.setInventaire(bonus);
        } else {
            int degats = random.nextInt(20)+ 20;
            System.out.println("Des pirates vous attaquent et font perdre " + degats + "pts de vie à votre vaisseau");
            vaisseau.prendreDegats(degats);
        }
        return vaisseau;
    }

    public String getNom() {
        return nom;
    }



}

