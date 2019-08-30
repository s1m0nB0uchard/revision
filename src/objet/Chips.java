package objet;

import vaisseau.Vaisseau;

public class Chips extends Objet {
    public Chips(){
        bonus= 20;
        nom = "Chips";
    }

    public void utiliser(Vaisseau vaisseau){
        vaisseau.setCarburant(vaisseau.getCarburant() + bonus);
        System.out.println("Vous utilisez " + nom + ", ce qui vous redonne " + bonus + " litres d'essence");
    }
}
