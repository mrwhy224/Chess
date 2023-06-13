package com.chess.base;

import java.util.ArrayList;

public abstract class PiecesGroup {
    public Objects.PiecesColor Color;
    private ArrayList<Piece> Pieces;
    public PiecesGroup(Objects.PiecesColor color) {
        Color = color;
    }
    public Objects.PiecesColor getColor() {
        return Color;
    }
    public boolean AddPieceToGroup(Piece pic) {
       return Pieces.add(pic);
    }
    public boolean RemovePieceFromGroup(Piece pic) {
        return Pieces.remove(pic);
    }
    public ArrayList<Piece> getPieces() {
        return Pieces;
    }
}
