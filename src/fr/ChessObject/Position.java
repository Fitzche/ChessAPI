package fr.ChessObject;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R1.Slot;

public class Position {
    public String name;
    public Board board;
    public int slot;

    public Position(String str, Board board, int slot) {
        this.name = str;
        this.board = board;
        this.slot = slot;
    }

    public ArrayList<Position> getPossiblePosition(PieceType type) {
        switch (type) {
            case FOU:
                break;
            case HORSE:
                break;
            case KING:
                break;
            case PION:
                break;
            case QUEEN:
                break;
            case TOWER:
                break;
            default:
                break;
            
        }
    }
}
