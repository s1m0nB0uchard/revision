package objet;

import vaisseau.Vaisseau;

public class Tournevis extends Objet {


    public Tournevis(){
        bonus= 20;
        nom = "Tournevis";
    }
    public void utiliser(Vaisseau vaisseau){
        vaisseau.setPtsVie(vaisseau.getPtsVie() + bonus);
        System.out.println("Vous utilisez " + nom + ", ce qui vous redonne " + bonus + "pts de vie");
    }

}
