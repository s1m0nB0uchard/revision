package planete;

import objet.Ethanol;
import objet.Objet;
import objet.Tournevis;

public class Poutine extends Planete {

    public Poutine(){
        nom="Poutine";
        liste.add(new Tournevis());
        liste.add(new Ethanol());

    }


}
