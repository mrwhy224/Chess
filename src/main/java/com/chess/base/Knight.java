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
    public ArrayList<Objects.Move> AvailableMoves(boolean isCheckMateAllowed) {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();
        for (Objects.Position position : possibleMovement) {
            boolean att = false;
            Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX() + position.getX(), this.getPiecePosition().getY() + position.getY());
            if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                att = true;
            Objects.Move move = new Objects.Move(this, this.getPiecePosition(), newPosition, att);
            if (this.getGameObj().CheckMove(move, isCheckMateAllowed))
                availableMoves.add(move);
        }
        return availableMoves;
    }
    public Piece createCopy(PiecesGroup group, Game gameObj) {
        return new Knight(group,gameObj).setFirstMove(this.isFirstMove()).setPiecePosition(this.getPiecePosition());
    }
}
