package com.chess.base;

import java.util.ArrayList;

public class King extends Piece {
    public King(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.King, group, gameObj, 0);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
