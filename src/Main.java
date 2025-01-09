import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        boolean jouer = true;
        boolean unique;
        
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

            System.out.println("MasterMind :");
            System.out.println("Deviner la séquence secrète composée de 5 chiffres avec 12 tentatives.");

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