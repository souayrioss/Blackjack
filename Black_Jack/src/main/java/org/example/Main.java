package org.example;

import org.example.entity.Cartes;

import java.util.HashMap;
import java.util.Map;

import static org.example.Utils.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Cartes> cartes = new HashMap<>();
        creatCartes(cartes);
        for (int i = 0; i < 100; i++) {
            extraire_ieme_carte(cartes);
            melanger_jeu_cartes(cartes);
        }
        cartes.forEach((key, value) -> {System.out.print(key + "=("+value.getType().getIndex() + " " +value.getValue().getIndex() + "), ");});

    }
}
//System.out.println(type + " " + value);