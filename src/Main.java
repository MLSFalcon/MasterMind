import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        boolean jouer = true;
        boolean unique;
        boolean victoire = false;
        boolean valide = false;
        String saisie;
        char[] chiffres = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        while (jouer == true) {
            int[] sequenceSecrete = new int[5];
            for (int i = 0; i < 5; i++) {
                do {
                    unique = true;
                    sequenceSecrete[i] = (int) (Math.random() * 9) + 1;
                    for (int j = 0; j < i; j++) {
                        if (sequenceSecrete[i] == sequenceSecrete[j]) {
                            unique = false;
                            break;
                        }
                    }
                } while (!unique);
            }

            System.out.println("Bienvenue dans MasterMind");
            System.out.println("Deviner la séquence secrète composée de 5 chiffres avec 12 tentatives.");

            for (int i = 1; i <= 12; i++) {
                System.out.println("Tentative " + i + ": Entrez une séquence de 5 chiffres : ");
                int[] proposition = new int[5];
                valide = false;

                while (!valide) {
                    saisie = clavier.next();
                    if (saisie.length() != 5) {
                        System.out.print("Erreur, Entrez exactement 5 chiffres : ");
                    } else {
                        valide = true;
                        for (int j = 0; j < 5; j++) {
                            char verification = saisie.charAt(j);
                            if (verification < '1' || verification > '9') {
                                valide = false;
                                break;
                            }
                            for (int a = 0; a < chiffres.length; a++) {
                                if (verification == chiffres[a]) {
                                    proposition[j] = a + 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (!valide) {
                        System.out.print("Erreur, Entrez exactement 5 chiffres : ");
                    }
                }


                int bienPlaces = 0;
                for (int j = 0; j < 5; j++) {
                    if (sequenceSecrete[j] == proposition[j]) {
                        bienPlaces++;
                    }
                }
                
            System.out.print("Voulez-vous rejouer ? (o/n) : ");
            String reponse = clavier.next().toUpperCase();
            while (!reponse.equals("N")&&!reponse.equals("O")&&!reponse.equals("OUI")&&!reponse.equals("NON")) {
                System.out.println("Saisir o/n");
                reponse = clavier.next().toUpperCase();
            }
            if (reponse.equals("O")||reponse.equals("OUI")) {
                jouer = true;
            } else {
                jouer = false;
            }
        }
        System.out.println("Merci d'avoir joué !");
    }
}