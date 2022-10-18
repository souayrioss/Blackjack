package org.example;

import org.example.entity.*;

import java.util.*;

public class Utils {
    private static Utils util;
    public static Utils getInstance(){
        if(Utils.util==null) {
            util=new Utils();
        }
        return util;
    }
    public ArrayList<Cartes> cartes_Player = new ArrayList<>();
    public ArrayList<Cartes> cartes_Dealer = new ArrayList<>();
    public ArrayList<Cartes> cartes_Defausser = new ArrayList<>();

    public ArrayList<Cartes> getCartes_Player() {
        return cartes_Player;
    }

    public void setCartes_Player(ArrayList<Cartes> cartes_Player) {
        this.cartes_Player = cartes_Player;
    }

    public ArrayList<Cartes> getCartes_Dealer() {
        return cartes_Dealer;
    }

    public void setCartes_Dealer(ArrayList<Cartes> cartes_Dealer) {
        this.cartes_Dealer = cartes_Dealer;
    }

    public ArrayList<Cartes> getCartes_Defausser() {
        return cartes_Defausser;
    }

    public void setCartes_Defausser(ArrayList<Cartes> cartes_Defausser) {
        this.cartes_Defausser = cartes_Defausser;
    }

    public  static boolean logIn(){
        System.out.println("Veillez saisir votre user name ");
        Scanner scanner=new Scanner(System.in);
        String username=scanner.nextLine();
        System.out.println("Veillez saisir votre Mot de passe");
        String password=scanner.nextLine();
        Optional<Players> optionalUser=Data.getInstance().users.stream().filter(user->user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)).findFirst();
        if(optionalUser.isPresent()){
            Data.isConnected = optionalUser.get();
            return true;
        }
        return false;
    }
    public static void start_game(HashMap<Integer,Cartes> cartes){

        piocher_n_cartes(cartes);
            System.out.println(util.getCartes_Player());
            System.out.println("La valeur de votre cartes :" + sum_value_player());
            System.out.println("Pour tirer une carte : 1");
            System.out.println("Pour rester : 2");
            int choix;
            do {
                Scanner scan = new Scanner(System.in);
                choix = scan.nextInt();
            }while (choix > 2);
            switch (choix){
                case 1:
                   piocher_carte(cartes);
                    break;
                case 2:
                    rester(cartes);

                    break;

            }
            defausser_cartes();
    }

    public static HashMap<Integer, Cartes> creatCartes(HashMap<Integer, Cartes> cartes){
        Cartes carte ;
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
        cartes.clear();
        cartes.putAll(cartes1);
        return cartes;
    }
    public static HashMap<Integer, Cartes>  melanger(HashMap<Integer, Cartes> cartes){
        extraire_ieme_carte(cartes);
        melanger_jeu_cartes(cartes);
        return cartes;
    }
    public static HashMap<Integer, Cartes>  piocher_n_cartes (HashMap<Integer, Cartes> cartes ){
        ArrayList<Cartes> cartes_Player = new ArrayList<>();
        ArrayList<Cartes> cartes_Dealer = new ArrayList<>();
        Utils util = Utils.getInstance();
        for (int i = 1; i < 5; i++) {
             Cartes carte = cartes.get(i);
             cartes.remove(i);
            if ( i%2 == 0) {
                cartes_Dealer.add(carte);
            }else{
                cartes_Player.add(carte);
            }
        }
        util.setCartes_Player(cartes_Player);
        util.setCartes_Dealer(cartes_Dealer);
        return cartes;
    }
    public static int sum_value_player(){
        int sum =0;
        for (int i = 0; i < util.getCartes_Player().size(); i++) {
            int value = util.getCartes_Player().get(i).getValue().getIndex();
            sum += value;
        }
        return sum;
    }
    public static int sum_value_dealer(){
        int sum =0;
        for (int i = 0; i < util.getCartes_Dealer().size(); i++) {
            int value = util.getCartes_Dealer().get(i).getValue().getIndex();
            sum += value;
        }
        return sum;
    }
    public static void defausser_cartes(){
        ArrayList<Cartes> defausser_cartes = new ArrayList<>();
        for (int i = 0; i < util.getCartes_Player().size(); i++) {
            defausser_cartes.add(util.getCartes_Player().get(i));
        }
        for (int i = 0; i < util.getCartes_Dealer().size(); i++) {
            defausser_cartes.add(util.getCartes_Dealer().get(i));
        }
        util.getCartes_Player().clear();
        util.getCartes_Dealer().clear();
        util.setCartes_Defausser(defausser_cartes);
    }
    public static HashMap<Integer, Cartes>  piocher_carte (HashMap<Integer, Cartes> cartes ){
        ArrayList<Cartes> cartes_Player ;
        Utils util = Utils.getInstance();
        int index = 52-cartes.size()+1;
        Cartes carte = cartes.get(index);
        cartes.remove(index);

        cartes_Player = util.getCartes_Player();
        cartes_Player.add(carte);
        util.setCartes_Player(cartes_Player);

        if(sum_value_player() > 21){
            System.out.println(util.getCartes_Player());
            System.out.println(sum_value_player());
            System.out.println(util.getCartes_Dealer());
            System.out.println("La valeur de tireur cartes :" + sum_value_dealer());
            System.err.println("LOSER");

        }

        sum_value_dealer();
        return cartes;
    }
    public static HashMap<Integer, Cartes>  piocher_carte_Dealer(HashMap<Integer, Cartes> cartes ){
        ArrayList<Cartes> cartes_Dealer ;
        Utils util = Utils.getInstance();
        int index = 52-cartes.size()+1;
        Cartes carte = cartes.get(index);
        cartes.remove(index);

        cartes_Dealer = util.getCartes_Dealer();
        cartes_Dealer.add(carte);
        util.setCartes_Dealer(cartes_Dealer);
        return cartes;
    }
    public static void rester(HashMap<Integer, Cartes> cartes ){
        if(sum_value_dealer() < 17) {
            while (sum_value_dealer() < 17) {
                piocher_carte_Dealer(cartes);
            }
        }
        System.out.println(util.getCartes_Dealer());
        System.out.println("La valeur de tireur cartes :" + sum_value_dealer());
            if (sum_value_dealer() > 21){
                System.err.println("WINER");
            }else {
                if (sum_value_dealer() > sum_value_player()) {
                    sum_value_dealer();
                    System.err.println("LOSER");
                } else if (sum_value_dealer() < sum_value_player()) {
                    sum_value_dealer();
                    System.err.println("WINER");
                } else {
                    System.err.println("PUSH");
                }
            }

    }


}
