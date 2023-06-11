package com.chess.base;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Queen, group, gameObj, 9);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        // toDo
        return null;
    }
}
