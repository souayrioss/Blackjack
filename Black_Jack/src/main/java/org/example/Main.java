package org.example;

import org.example.entity.Cartes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.example.Utils.*;

public class Main {
    private static Data data;
    public static void main(String[] args) {
        data=Data.getInstance();
        System.out.println("**************Welcome__to__Your__Favorite__Game*********");
            while (!Utils.logIn()) {
                System.err.println("Les informations sont incorrect");
            }
            double sold = Data.isConnected.getMoney();
            HashMap<Integer, Cartes> cartes = new HashMap<>();
            creatCartes(cartes);
            for (int i = 0; i < 100; i++) {
                melanger(cartes);
            }
            int choix;
            do {
                System.out.println("Pour commencer à jouer : 1");
                System.out.println("Pour verifier votre solde : 2");
                System.out.println("Pour Quiter: 0");

                do {
                    Scanner scan = new Scanner(System.in);
                    choix = scan.nextInt();
                }while (choix > 2);
                switch (choix) {
                    case 1:

                        start_game(cartes);
                        break;
                    case 2:
                        System.out.println("votre solde est : " +sold);
                        break;
                    case 0:
                        System.out.println("Wednesday");
                        break;

                }
            }while (choix != 0 );

    }
}
/*        int sum = 0;
        for (int i = 0; i < Utils.getInstance().getCartes_Player().size(); i++) {
            int value = Utils.getInstance().getCartes_Player().get(i).getValue().getIndex();
            System.out.println(value);
            sum = sum + value;

        }
        System.out.println(sum);
        sum = 0;
        for (int i = 0; i < Utils.getInstance().getCartes_Player().size(); i++) {
            int value = Utils.getInstance().getCartes_Dealer().get(i).getValue().getIndex();
            System.out.println(value);
            sum = sum + value;

        }
        System.out.println(sum);
        data.saveData();

 */