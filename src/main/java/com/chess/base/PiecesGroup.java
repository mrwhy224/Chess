package com.chess.base;

import java.util.ArrayList;

public class PiecesGroup {
    public Objects.PiecesColor Color;
    private ArrayList<Piece> Pieces;
    public Objects.PiecesColor getColor() {
        return Color;
    }
    public void setColor(Objects.PiecesColor color) {
        Color = color;
    }
    public boolean AddPieceToGroup(Piece pic, Game game) {
        pic.setGroup(this);
        pic.setGameObj(game);
       return Pieces.add(pic);
    }
    public boolean RemovePieceFromGroup(Piece pic) {
        return Pieces.remove(pic);
    }
    public ArrayList<Piece> getPieces() {
        return Pieces;
    }
}
