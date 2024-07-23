package fr.ChessObject;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R1.Slot;

public class Position {
    public String name;
    public Board board;
    public int slot;
    public int letter;
    public int number;

    public Position(String str, Board board, int slot, int letter, int number) {
        this.name = str;
        this.board = board;
        this.slot = slot;
        this.letter = letter;
        this.number = number;
    }

    public ArrayList<Position> getPossiblePosition(PieceType type) {
        ArrayList<Position> possiblesPositions = new ArrayList<Position>();
        switch (type) {
            case FOU:
                for (Position pos:board.getPositions()) {
                    int lDif = 0;
                    int nDif = 0;
                    if (pos.letter != this.letter & pos.number != this.number) {
                        if (pos.letter > this.letter) {
                            lDif = pos.letter - this.letter;
                        }  else {
                            lDif = this.letter - pos.letter;
                        }

                        if (pos.number > this.number) {
                            nDif = pos.number - this.number;
                        }  else {
                            nDif = this.number - pos.number;
                        }

                        if (nDif == lDif) {
                            possiblesPositions.add(pos);
                        }


                    }
                    
                }
            case HORSE:
                for (Position pos: board.getPositions()) {
                    int lDif = 0;
                    int nDif = 0;
                    if (pos.letter != this.letter & pos.number != this.number) {
                        if (pos.letter > this.letter) {
                            lDif = pos.letter - this.letter;
                        }  else {
                            lDif = this.letter - pos.letter;
                        }

                        if (pos.number > this.number) {
                            nDif = pos.number - this.number;
                        }  else {
                            nDif = this.number - pos.number;
                        }

                        if ((nDif == 2 && lDif == 1) || (nDif == 1 && lDif == 2)) {
                            possiblesPositions.add(pos);
                        }


                    }
                }
            case KING:
                for (Position pos: board.getPositions()) {
                    int lDif = 0;
                    int nDif = 0;
                    if (pos.letter != this.letter & pos.number != this.number) {
                        if (pos.letter > this.letter) {
                                lDif = pos.letter - this.letter;
                            }  else {
                                lDif = this.letter - pos.letter;
                            }

                        if (pos.number > this.number) {
                                nDif = pos.number - this.number;
                            }  else {
                                nDif = this.number - pos.number;
                        }

                        if (nDif < 2 && lDif < 2) {
                            possiblesPositions.add(pos);
                        }


                    }
                }
            case PION:
                
            case QUEEN:
                break;
            case TOWER:
                break;
            default:
                break;
            
        }
    }
}
