package org.example;

import org.example.entity.Dealer;
import org.example.entity.Players;
import org.example.entity.Roles;
import org.example.entity.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data implements Serializable {
 /*   private static Data data;
    public static Users isConnected=null;
    private static final String filePath="./src/main/java/org/example/data.txt";
    public List<Users> users;
    public Set<Roles> roles;

    public Data() {
        this.users = new ArrayList<>();
        this.roles = new HashSet<>();
    }
    public static Data getInstance(){
        if(Data.data==null) {
            if(!ChargeData()){
                data=new Data();
                data.CreateData();
            }
        }
        return data;
    }
    private static boolean ChargeData(){
        if(!new File(filePath).exists()) {
            System.out.println("no previous data found!");
            return false;
        }
        try{
            System.out.println("reading object from file");
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));
            data= (Data) ois.readObject();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void saveData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(data);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void CreateData(){
        Roles Player = Roles.PLAYER;
        Roles Dealer = Roles.DEALER;

        Dealer dealer = new Dealer();
        dealer.setUsername("sliim");
        dealer.setPassword("azerty");
        dealer.setRole(Dealer);
        this.users.add(dealer);

        Players playerOussama = new Players();
        playerOussama.setUsername("souayrioss");
        playerOussama.setPassword("azerty");
        playerOussama.setRole(Player);
        playerOussama.setMoney(1000.63);
        this.users.add(playerOussama);

        Players playerYasser = new Players();
        playerYasser.setUsername("yasser");
        playerYasser.setPassword("azerty");
        playerYasser.setRole(Player);
        playerYasser.setMoney(10440.22);
        this.users.add(playerYasser);

        Players playerSalim = new Players();
        playerSalim.setUsername("sliim");
        playerSalim.setPassword("azerty");
        playerSalim.setRole(Player);
        playerSalim.setMoney(4080.654);
        this.users.add(playerSalim);



    }
    
  */

}
