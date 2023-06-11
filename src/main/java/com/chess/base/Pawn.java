package com.chess.base;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Pawn, group, gameObj, 1);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
