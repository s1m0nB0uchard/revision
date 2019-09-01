package planete;

import objet.CanisseDeGaz;
import objet.Chips;
import objet.Ethanol;

public class Emma extends Planete {
    public Emma(){
        nom="Emma";

       liste.add(new CanisseDeGaz());
       liste.add(new Chips());
       liste.add(new Ethanol());
    }


}
