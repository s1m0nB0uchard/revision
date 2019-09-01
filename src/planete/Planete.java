package planete;

import objet.*;
import personnages.Astronaute;
import personnages.Mecanicien;
import personnages.Perso;
import vaisseau.Vaisseau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Planete implements Serializable {

    protected String nom;
    private Objet bonus;
    protected ArrayList<Objet> liste = new ArrayList<>();


    public Vaisseau explorer(Vaisseau vaisseau, Perso personnage) {
        Random random = new Random();
        vaisseau.setCarburant(vaisseau.getCarburant() - (random.nextInt(10) + 5));
        int chance = random.nextInt(3);

        if (chance == 0) {
            bonus = obtenirObjetHasard();
            System.out.println("Vous avez trouvé " + bonus.getNom());
            vaisseau.setInventaire(bonus);
        } else {
            int degats = random.nextInt(20) + 20;
            System.out.printf("Des pirates vous attaquent et font perdre " + degats + "pts de vie à votre vaisseau" + "%n" + "%n");
            vaisseau.prendreDegats(degats);


            if (chance == 1) {
                int x = 40;
                System.out.println("Votre vaisseau subit des dommages majeurs lors de l'entrée dans l'atmosphère (une sortie extra véhiculaire serait nécessaire)");
                if (personnage instanceof Astronaute) {
                    System.out.println("Heureusement, vous êtes un astronaute donc une petite sortie hors du vaisseau et vous réparez à 75% les dégats engendrés.");
                    int y = (int) (x * 0.25);
                    System.out.println("Votre vaisseau perd seulement " + y + " points de vie au lieu de " + x);
                } else {
                    System.out.println("Votre vaisseau perd donc " + x + " points de vie");
                }
                vaisseau.prendreDegats(40);
            } else if (chance == 2) {
                int x = 20;
                System.out.println("Vous rencontrez de forts vents solaires, ce qui augmente votre consommation d'essence de " + x + " litres supplémentaires.");
                if (personnage instanceof Mecanicien) {
                    System.out.println("Heureusement, comme tout bon mécanicien, vous trainez un bidon d'essence sur vous!");
                    System.out.println("Le vaisseau n'engendre aucune perte d'essence supplémentaire!");
                }
                else{
                    vaisseau.gagnerEssence(-20);
                }
            } else {

            }


        }
        return vaisseau;
    }

    public String getNom() {
        return nom;
    }

    public Objet obtenirObjetHasard() {
        Random random = new Random();
        return liste.get(random.nextInt(liste.size()));
    }


}

