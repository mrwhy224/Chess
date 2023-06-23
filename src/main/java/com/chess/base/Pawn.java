package com.chess.base;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Pawn, group, gameObj, 1);
    }
    public ArrayList<Objects.Move> AvailableMoves(boolean isCheckMateAllowed) {

        ArrayList<Objects.Move> availableMoves = new ArrayList<>();

        for (int j = 1; j < (this.isFirstMove()?3:2) ; j++) {
            if (this.getGroup().getColor() == Objects.PiecesColor.Black)
                j = -j; // The step is reversed, considering that white pieces go to houses with higher index and black pieces go to houses with lower index


            Objects.Move move = new Objects.Move(this, this.getPiecePosition(), new Objects.Position(this.getPiecePosition().getX(), this.getPiecePosition().getY() + j), false);
            if (this.getGameObj().CheckMove(move,isCheckMateAllowed))
                availableMoves.add(move);

            if(abs(j) == 1) { // Checks if the soldier can attack or not
                move = new Objects.Move(this, this.getPiecePosition(), new Objects.Position(this.getPiecePosition().getX() + 1, this.getPiecePosition().getY() + j), true);
                if (this.getGameObj().CheckMove(move,isCheckMateAllowed))
                    availableMoves.add(move);

                move = new Objects.Move(this, this.getPiecePosition(), new Objects.Position(this.getPiecePosition().getX() - 1, this.getPiecePosition().getY() + j), true);
                if (this.getGameObj().CheckMove(move,isCheckMateAllowed))
                    availableMoves.add(move);
            }
        }
        return availableMoves;
    }
    public Piece createCopy(PiecesGroup group, Game gameObj) {
        return new Pawn(group,gameObj).setFirstMove(this.isFirstMove()).setPiecePosition(this.getPiecePosition());
    }
}
