package com.chess.base;

import java.util.ArrayList;

public abstract class PiecesGroup {
    public Objects.PiecesColor Color;
    private ArrayList<Piece> Pieces;
    private Game game;
    public PiecesGroup(Objects.PiecesColor color, Game game) {
        this.Color = color;
        this.game = game;
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

    public Game getGame() {
        return game;
    }
}
