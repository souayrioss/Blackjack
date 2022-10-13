package org.example;

import org.example.entity.Cartes;
import org.example.entity.Types;
import org.example.entity.Users;
import org.example.entity.Values;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Utils {

    /*public  static boolean logIn(){
        System.out.println("Veillez saisir votre email");
        Scanner scanner=new Scanner(System.in);
        String email=scanner.nextLine();
        System.out.println("Veillez saisir votre Mot de passe");
        String password=scanner.nextLine();
        Optional<Users> optionalUser=Data.getInstance().users.stream().filter(user->user.getUsername().equalsIgnoreCase(email) && user.getPassword().equals(password)).findFirst();
        if(optionalUser.isPresent()){
            Data.isConnected = optionalUser.get();
            return true;
        }
        return false;
    }*/

    public static HashMap<Integer, Cartes> creatCartes(HashMap<Integer, Cartes> cartes){
        Utils utils = new Utils();
        Cartes carte = new Cartes();
        int i =0 ;
        for (Types type : Types.values()) {
            for (Values value : Values.values()){
                i++;
                carte = new Cartes();
                carte.setType(type);
                carte.setValue(value);
                cartes.put(i,carte);
            }
        }
        //cartes.forEach((key, value) -> {System.out.println(value.getType().getIndex() + " " +value.getValue().getIndex());});
        return  cartes;
    }
    public static HashMap<Integer, Cartes>  extraire_ieme_carte(HashMap<Integer, Cartes> cartes){
       int randNum = (int) ((Math.random() * (52 - 1)) + 1);
       int i=1;
        Cartes carte = cartes.get(randNum);
        cartes.remove(randNum);
        HashMap<Integer, Cartes> cartes1 = new HashMap<>();
        cartes1.put(i,carte);
        for (int j = 0; j < cartes.size(); j++) {
            i++;
            cartes1.put(i, (Cartes) cartes.values().toArray()[j]);
        }
        //cartes1.forEach((key, value) -> {System.out.print(key + "\n\n=("+value.getType().getIndex() + " " +value.getValue().getIndex() + "), ");});
        cartes.clear();
        cartes.putAll(cartes1);
        return cartes;
    }
    public static HashMap<Integer, Cartes>  melanger_jeu_cartes (HashMap<Integer, Cartes> cartes){
        int randNum = (int) ((Math.random() * (52 - 1)) + 1);
        int i=1;
        Cartes carte = cartes.get(randNum);
        cartes.remove(randNum);
        HashMap<Integer, Cartes> cartes1 = new HashMap<>();

        for (int j = 0; j < cartes.size(); j++) {
            cartes1.put(i, (Cartes) cartes.values().toArray()[j]);
            i++;
        }
        cartes1.put(i,carte);
        //cartes1.forEach((key, value) -> {System.out.print(key + "\n\n=("+value.getType().getIndex() + " " +value.getValue().getIndex() + "), ");});
        cartes.clear();
        cartes.putAll(cartes1);
        return cartes;
    }


}
