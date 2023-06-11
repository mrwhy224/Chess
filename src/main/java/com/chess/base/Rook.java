package com.chess.base;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Rook, group, gameObj, 5);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
