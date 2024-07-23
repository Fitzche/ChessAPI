package fr.ChessObject;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class Board {
    public ArrayList<Position> poss = new ArrayList<Position>();
    public Inventory inv = Bukkit.createInventory(null, 72);


    public Board() {
        for (int i = 0; i<8; i++) {
            for (int i2 = 0; i<8; i++) {
                String l= "";
                String n ="";
                switch (i) {
                    case 0:
                        l = "A";
                    case 1:
                        l = "B";
                    case 2:
                        l = "C";
                    case 3:
                        l = "D";
                    case 4:
                        l = "E";
                    case 5:
                        l = "F";
                    case 6:
                        l = "G";
                    case 7:
                        l = "H";
                    

                }
                switch (i2) {
                    case 0:
                        n = "1";
                    case 1:
                        n = "2";
                    case 2:
                        n = "3";
                    case 3:
                        n = "4";
                    case 4:
                        n = "5";
                    case 5:
                        n = "6";
                    case 6:
                        n = "7";
                    case 7:
                        n = "8";
                    

                }

                int x = 9*(i-1);
                if (x==0) {
                    x = 0;
                }
                poss.add(new Position((l+n), this, (64 -x  + i2), i, i2 ) );
            }
        }
        if (this.poss.size() != 64) {
            System.out.println("erreur creation board");
        }

    }

    public ArrayList<Position> getPositions() {
        return this.poss;
    }

    public Position getPosition(int letter, int number) {
        for (Position pos: this.getPositions()) {
            if (pos.letter == letter && pos.number == number) {
                return pos;
            }
        }
        return null;
    }


    public Position takeUp() {

    }
    public Position takeUpRight() {
        
    }
    public Position takeRight() {
        
    }
    public Position takeDownRight() {
        
    }
    public Position takeDown() {
        
    }
    public Position takeUpLeft() {
        
    }
    public Position takeDownLeft() {
        
    }
    public Position takeLeft() {
        
    }
}
