package planete;


import objet.Marteau;
import objet.Tournevis;

public class IronMan extends Planete {
        public IronMan(){
            nom="Iron Man";

            liste.add(new Tournevis());
            liste.add(new Marteau());
            liste.add(new Tournevis());
        }

}

