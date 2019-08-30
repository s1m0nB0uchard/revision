package objet;

import vaisseau.Vaisseau;

public class CanisseDeGaz extends Objet {
    public CanisseDeGaz(){
        bonus= 20;
        nom = "Bidon d'essence";
    }

    public void utiliser(Vaisseau vaisseau){
        vaisseau.setCarburant(vaisseau.getCarburant() + bonus);
        System.out.println("Vous utilisez " + nom + ", ce qui vous redonne " + bonus + " litres d'essence");
    }
}
