package com.chess.base;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Bishop, group, gameObj, 3);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
