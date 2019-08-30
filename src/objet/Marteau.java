package objet;

import vaisseau.Vaisseau;

public class Marteau extends Objet {
    public Marteau(){
        bonus= 20;
        nom = "Marteau";
    }
    public void utiliser(Vaisseau vaisseau){
        vaisseau.setPtsVie(vaisseau.getPtsVie() + bonus);
        System.out.println("Vous utilisez " + nom + ", ce qui vous redonne " + bonus + "pts de vie");
    }
}
