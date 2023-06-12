package com.chess.base;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Knight, group, gameObj, 3);
    }

    private final Objects.Position[] possibleMovement = {
            new Objects.Position(2,1),
            new Objects.Position(1,2),
            new Objects.Position(-1,2),
            new Objects.Position(-2,1),
            new Objects.Position(-2,-1),
            new Objects.Position(-1,-2),
            new Objects.Position(1,-2),
            new Objects.Position(2,-1)
    };
    public ArrayList<Objects.Move> AvailableMoves() {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();
        for (int i = 0; i< possibleMovement.length; i++)
        {
            boolean att = false;
            Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX()+ possibleMovement[i].getX(),this.getPiecePosition().getY()+ possibleMovement[i].getY());
            if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                att = true;
            Objects.Move move = new Objects.Move(this ,this.getPiecePosition(), newPosition,att);
            if(this.getGameObj().CheckMove(move))
                availableMoves.add(move);
        }
        return availableMoves;
    }
}
