package com.chess.base;

public class Pawn extends Piece {
    public Pawn(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Pawn, group, gameObj, 1);
    }
}
