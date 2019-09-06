package exception;

public class Exceptions {


    public class numeroInvalide extends Exception {

        @Override
        public String toString() {
            String erreur = "le chiffre saisi est erroné";
            return  erreur;
        }
    }



    public boolean tryNumber(int nb) throws numeroInvalide {
        boolean bool = false;
        if (nb <= 0) {
            bool = true;
            throw new numeroInvalide();

        } else bool = false;

        return bool;
    }


}
