package fr.ChessObject;

public interface GameInterface {
    public Rapport play(int pos1letter, int pos1number, int pos2letter, int pos2number);
    public void winListener(Color color);
    public void nulListener();
    


}
