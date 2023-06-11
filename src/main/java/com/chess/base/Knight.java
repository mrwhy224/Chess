package com.chess.base;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Knight, group, gameObj, 3);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
