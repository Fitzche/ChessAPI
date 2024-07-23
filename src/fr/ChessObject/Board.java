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
    public boolean checkExist(int letter, int number) {
        Position pos = getPosition(letter, number);
        if (pos != null) {
            return true;
        } else {
            return false;
        }
    }


    public Position takeUp(Position pos) {
        return getPosition(pos.letter, pos.number +1);

    }
    public Position takeUpRight(Position pos) {
        return getPosition(pos.letter +1, pos.number +1);
    }
    public Position takeRight(Position pos) {
        return getPosition(pos.letter+1, pos.number );
    }
    public Position takeDownRight(Position pos) {
        return getPosition(pos.letter+1, pos.number -1);
    }
    public Position takeDown(Position pos) {
        return getPosition(pos.letter, pos.number -1);
    }
    public Position takeUpLeft(Position pos) {
        return getPosition(pos.letter -1, pos.number +1);
    }
    public Position takeDownLeft(Position pos) {
        return getPosition(pos.letter-1, pos.number -1);
    }
    public Position takeLeft(Position pos) {
        return getPosition(pos.letter-1, pos.number );
    }
    public ArrayList<Position> takeDiagonaleUpRight(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeUpRight(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }
    public ArrayList<Position> takeDiagonaleUpLeft(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeUpLeft(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }
    public ArrayList<Position> takeDiagonaleDownRight(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeDownRight(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }
    public ArrayList<Position> takeDiagonaleDownLeft(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeDownLeft(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }


    public ArrayList<Position> takeDroiteUp(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeUp(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }

    public ArrayList<Position> takeDroiteDown(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeDown(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }

    public ArrayList<Position> takeDroiteRight(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeRight(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }

    public ArrayList<Position> takeDiagonaleLeft(Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeLeft(actualPos);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;

    }
    

    
}
