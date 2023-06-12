package com.chess.base;

import java.util.ArrayList;

public class King extends Piece {
    public King(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.King, group, gameObj, 0);
    }
    public ArrayList<Objects.Move> AvailableMoves() {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();
        for (int i=-1; i<2; i++)
            for (int j=-1; j<2; j++)
            {
                boolean att = false;
                Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX()+i, this.getPiecePosition().getY()+j);
                if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                    att = true;
                Objects.Move move = new Objects.Move(this, this.getPiecePosition(), newPosition, att);
                if(this.getGameObj().CheckMove(move))
                    availableMoves.add(move);
            }
        return availableMoves;
    }
}
