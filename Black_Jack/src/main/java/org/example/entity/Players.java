package org.example.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Players extends Users implements Serializable {
      private double money;
      private  ArrayList<Cartes> cartes_Player = new ArrayList<>();

      public Players() {
      }

      public double getMoney() {
            return money;
      }

      public void setMoney(double money) {
            this.money = money;
      }

      public ArrayList<Cartes> getCartes_Player() {
            return cartes_Player;
      }

      public void setCartes_Player(ArrayList<Cartes> cartes_Player) {
            this.cartes_Player = cartes_Player;
      }
}
