
import vaisseau.Vaisseau;
import sauvegardes.Saves;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class main {


    static void afficherMenu() {
        System.out.printf("1- Examiner l'état du vaisseau" + "%n" + "2- Explorer une planète" + "%n" +
                "3- Utiliser un objet dans l'inventaire" + "%n" + "4- Annuler le dernier déplacement" + "%n" + "5- Sauvegarder" +
                "%n" + "6- Charger une sauvegarde" + "%n");
    }

    public static void main(String[] args) {

        String nomDossier = "./Saves";
        Path path1 = Paths.get(nomDossier);
        File dossier = new File(nomDossier);
        try {
            if (!dossier.exists()) {
                Files.createDirectory(path1);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


        Scanner scan = new Scanner(System.in);
        boolean essence = true, enVie = true;

        Vaisseau vaisseau = new Vaisseau();

        while (essence && enVie) {
            System.out.println();
            afficherMenu();
            int choix = scan.nextInt();

            switch (choix) {
                case 1:
                    vaisseau.afficherStats();
                    break;

                case 2:
                    vaisseau.explorer();
                    vaisseau.planeteExplore();
                    break;

                case 3:
                    if (!vaisseau.afficherInventaire())
                        vaisseau.reparer(scan.nextInt());
                    break;

                case 4:
                    vaisseau.annulerParcours();
                    break;
                case 5:
                    System.out.print("Donnez un nom à votre sauvegarde:  ");
                    String nom = scan.next();
                    try {
                        Saves.sauvegarderVaisseau(vaisseau, nom);
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }

                    break;

                case 6:
                    if (Saves.afficherSauvegardes()){}
                    else {
                        try {
                            System.out.print("Entrez le nom de la sauvegarde: ");
                            String saveName = scan.next();
                            vaisseau = Saves.readList(saveName);
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }

                    }
                    break;

                default:
                    System.out.println("Try again");


            }
            if (vaisseau.checkGaz()) {
                essence = false;
                System.out.println("Plus de carburant");
            } else if (vaisseau.checkEnVie()) {
                enVie = false;
                System.out.println("Le vaisseau a subit trop de dégat et il EXPLOSE");
            }
        }

        System.out.println("Votre parcours: ");
        vaisseau.afficherParcours();

    }
}
