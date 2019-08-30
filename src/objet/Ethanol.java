package objet;

import vaisseau.Vaisseau;

public class Ethanol extends Objet {
    public Ethanol(){
        bonus= 20;
        nom = "Éthanol";
    }
    public void utiliser(Vaisseau vaisseau){
        vaisseau.setCarburant(vaisseau.getCarburant() + bonus);
        System.out.println("Vous utilisez " + nom + ", ce qui vous redonne " + bonus + " litres d'essence");
    }
}
