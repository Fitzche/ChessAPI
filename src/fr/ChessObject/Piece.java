package fr.ChessObject;

public class Piece {
    public Board board;
    public PieceType type;
    public Position pos;
    public Color color;

    public Piece(Board board, PieceType type, Position pos, Color color) {
        
        if (!pos.board.equals(board)) {
            return;
        }
        this.board = board;
        this.type = type;
        this.pos = pos;
        this.color = color;
    }
}
