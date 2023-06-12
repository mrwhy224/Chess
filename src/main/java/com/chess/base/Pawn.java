package com.chess.base;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Pawn, group, gameObj, 1);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();
        for (int j = 1; j < (this.isFirstMove()?3:2) ; j++) {
            if (this.getGroup().getColor() == Objects.PiecesColor.Black)
                j = -j;
            Objects.Move move;
            Objects.Position newPosition;

            newPosition = new Objects.Position(this.getPiecePosition().getX(), this.getPiecePosition().getY() + j);
            move = new Objects.Move(this, this.getPiecePosition(), newPosition, false);
            if (this.getGameObj().CheckMove(move))
                availableMoves.add(move);

            if(abs(j) == 1) {
                newPosition = new Objects.Position(this.getPiecePosition().getX() + 1, this.getPiecePosition().getY() + j);
                move = new Objects.Move(this, this.getPiecePosition(), newPosition, true);
                if (this.getGameObj().CheckMove(move))
                    availableMoves.add(move);
                newPosition = new Objects.Position(this.getPiecePosition().getX() - 1, this.getPiecePosition().getY() + j);
                move = new Objects.Move(this, this.getPiecePosition(), newPosition, true);
                if (this.getGameObj().CheckMove(move))
                    availableMoves.add(move);
            }
        }
        return availableMoves;
    }
}
