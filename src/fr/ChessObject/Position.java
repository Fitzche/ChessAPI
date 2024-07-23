package fr.ChessObject;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R1.Slot;

public class Position {
    public String name;
    public Board board;
    public int slot;
    public int letter;
    public int number;
    public Piece piece;
    public boolean canBePassed;

    public Position(String str, Board board, int slot, int letter, int number) {
        this.name = str;
        this.board = board;
        this.slot = slot;
        this.letter = letter;
        this.number = number;
    }

    public ArrayList<Position> getPossiblePosition(PieceType type, Color color) {
        ArrayList<Position> poss = new ArrayList<Position>();
        switch (type) {
            case FOU:
                
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down_Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down_Right, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up_Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up_Right, this));
                

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

                        if (((nDif == 2 && lDif == 1) || (nDif == 1 && lDif == 2)) && (pos.piece == null || !pos.piece.color.equals(this.piece.color))) {
                            poss.add(pos);
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

                        if ((nDif < 2 && lDif < 2) && (pos.piece == null || !pos.piece.color.equals(this.piece.color))) {
                            poss.add(pos);
                        }


                    }
                }
                
                
            case PION:
                ArrayList<Position> possToReturn = new ArrayList<Position>();
                if (board.takeUpRight(this).canBePassed||(board.getPosition(letter + 1, number + 1).piece != null && !board.getPosition(letter + 1, number + 1).piece.color.equals(this.piece.color))) {
                    poss.add(board.getPosition(letter + 1, number +1));
                }
                if (board.takeUpLeft(this).canBePassed||(board.getPosition(letter - 1, number + 1).piece != null && !board.getPosition(letter + 1, number + 1).piece.color.equals(this.piece.color))) {
                    poss.add(board.getPosition(letter - 1, number +1));
                }
                if (board.takeUp(this).piece == null) {
                    poss.add(board.takeUp(this));
                }
                if (board.takeUp(this).piece == null && board.takeUp(board.takeUp(this)).piece == null && ((color.equals(Color.WHITE) && number == 2) || (color.equals(Color.BLACK) && number == 7))) {
                    poss.add(board.takeUp(board.takeUp(this)));
                }
                
            case QUEEN:
                
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down_Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down_Right, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up_Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up_Right, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Right, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down, this));
                
            case TOWER:
                
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Left, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Right, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Up, this));
                poss.addAll(board.takeDroiteDiectionPieceLogique(color, Direction.Down, this));
                
            case KING_NOMOVE:
                return getPossiblePosition(PieceType.KING, color);
            case TOWER_NOMOVE:
                return getPossiblePosition(PieceType.TOWER, color);
            default:
                break;
            
        }

        return poss;
    }
}
