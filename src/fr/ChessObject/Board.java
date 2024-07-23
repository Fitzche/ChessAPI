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
    public Position takeDirection(Position pos, Direction dir) {
        switch (dir) {
            case Down:
                return takeDown(pos);
            case Down_Left:
                return takeDownLeft(pos);
            case Down_Right:
                return takeDownRight(pos);
            case Left:
                return takeLeft(pos);
            case Right:
                return takeRight(pos);
            case Up:
                return takeUp(pos);
            case Up_Left:
                return takeUpLeft(pos);
            case Up_Right:
                return takeUpRight(pos);
            default:
                return null;
            
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

    public ArrayList<Position> takeDroiteDirection(Direction dir, Position pos) {
        ArrayList<Position> poss = new ArrayList<Position>();
        Position actualPos = pos;
        boolean finished = false;
        do {
            Position posToAdd = takeDirection(actualPos, dir);
            if (posToAdd != null) {
                poss.add(actualPos);
                actualPos = posToAdd;
            } else {
                finished = true;
            }
        } while (!finished);

        return poss;
    }

    public ArrayList<Position> takeDroiteDiectionPieceLogique(Color color, Direction dr, Position pos) {
        ArrayList<Position> poss = takeDroiteDirection(dr, pos);
        ArrayList<Position> possreturned = new ArrayList<Position>();
        boolean stop = false;
        int x = 0;
        do {
            stop = true;
            if (pos.piece == null) {
                stop = false;
                possreturned.add(pos);
            } else if (!pos.piece.color.equals(color)) {
                possreturned.add(pos);
            }
            
        }while (!stop);
        return possreturned;

    }


    public boolean checkPlay(Position posBase, Position posArr) {
        boolean legalMove = false;
        boolean smallRock = false;
        boolean tallRock = false;
        Color color = posBase.piece.color;
        for (Position pos: posBase.getPossiblePosition(posBase.piece.type, posBase.piece.color)) {
            if (pos.equals(posArr)) {
                legalMove = true;
            }
        }

        if (posBase.piece.type.equals(PieceType.KING_NOMOVE)) {
            if (posArr.number == posBase.number && (posBase.letter - posArr.letter == 2 || posBase.letter - posArr.letter == -2)) {
                if (posBase.letter - posArr.letter == 2) {
                    if (this.getPosition(posBase.letter, posBase.number +1).piece == null && this.getPosition(posBase.letter, posBase.number +2).piece == null && this.getPosition(posBase.letter, posBase.number +3).piece != null && this.getPosition(posBase.letter, posBase.number +3).piece.type.equals(PieceType.TOWER_NOMOVE)) {
                        boolean safe = true;
                        if (!checkKingSafety(posBase, this.getPosition(posBase.letter, posBase.number +1), color)) {
                            safe = false;
                        } else if (!checkKingSafety(posBase, this.getPosition(posBase.letter, posBase.number +2), color)) {
                            safe = false;
                        } 
                        
                        if (safe) {
                            smallRock = true;
                            legalMove = true;
                        }
                        
                    }
                }

                if (posBase.letter - posArr.letter == -2) {
                    if (this.getPosition(posBase.letter, posBase.number -3).piece == null&&this.getPosition(posBase.letter, posBase.number -1).piece == null && this.getPosition(posBase.letter, posBase.number -2).piece == null && this.getPosition(posBase.letter, posBase.number -4).piece != null && this.getPosition(posBase.letter, posBase.number -4).piece.type.equals(PieceType.TOWER_NOMOVE)) {
                        boolean safe = true;
                        if (!checkKingSafety(posBase, this.getPosition(posBase.letter, posBase.number -1), color)) {
                            safe = false;
                        } else if (!checkKingSafety(posBase, this.getPosition(posBase.letter, posBase.number -2), color)) {
                            safe = false;
                        }  else if (!checkKingSafety(posBase, this.getPosition(posBase.letter, posBase.number -3), color)) {
                            safe = false;
                        }
                        
                        if (safe) {
                            smallRock = true;
                            legalMove = true;
                        }
                        
                    }
                }
            }
        }


        if (!checkKingSafety(posBase, posArr, color)) {
            legalMove = false;
        }

        return legalMove;

        
        
    }


    public boolean checkKingSafety(Position posBase, Position posArr, Color color) {
        boolean legalMove = true;
        Board board2 = new Board();
        board2.poss = (ArrayList<Position>) this.poss.clone();
        for (Position pos2:board2.getPositions()) {
            if (pos2.piece != null && (pos2.piece.type.equals(PieceType.KING) || pos2.piece.type.equals(PieceType.KING_NOMOVE) ) && pos2.piece.color.equals(color)) {
                        
                board2.getPosition(posArr.letter, posArr.number).piece = board2.getPosition(posBase.letter, posBase.number).piece;
                board2.getPosition(posBase.letter, posBase.number).piece = null;
                for (Position posss: board2.getPositions()) {
                    if (posss.equals(pos2)) {
                        legalMove = false;
                    }
                }
            }
        }

        return legalMove;
    }

}
