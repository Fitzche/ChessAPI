package fr;

import fr.ChessObject.Rapport;

public interface GameInterface {
    public Rapport play(int pos1letter, int pos1number, int pos2letter, int pos2number);
    public void winListener();
    


}
