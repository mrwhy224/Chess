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
    public ArrayList<Objects.Move> getPieceGroupAvailableMoves() {
        ArrayList<Objects.Move> moves = new ArrayList<>();
        for (Piece pic:getPieces())
            moves.addAll(pic.AvailableMoves());
        return moves;
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
