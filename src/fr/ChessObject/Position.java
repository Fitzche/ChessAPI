package fr.ChessObject;

public class Position {
    public String name;
    public Board board;

    public Position(String str, Board board) {
        this.name = str;
        this.board = board;
    }
}
