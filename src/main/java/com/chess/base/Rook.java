package com.chess.base;
import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Rook, group, gameObj, 5);
    }
    public ArrayList<Objects.Move> AvailableMoves(boolean isCheckMateAllowed) {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();

        for (int i = -this.getPiecePosition().getX(); i < 8 - this.getPiecePosition().getX(); i++) {
            boolean att = false;
            Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX() + i, this.getPiecePosition().getY());
            if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                att = true;
            Objects.Move move = new Objects.Move(this, this.getPiecePosition(), newPosition, att);
            if (this.getGameObj().CheckMove(move,isCheckMateAllowed))
                availableMoves.add(move);
        }
        for (int j = -this.getPiecePosition().getY(); j < 8 - this.getPiecePosition().getY(); j++) {
            boolean att = false;
            Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX(), this.getPiecePosition().getY() + j);
            if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                att = true;
            Objects.Move move = new Objects.Move(this, this.getPiecePosition(), newPosition, att);
            if (this.getGameObj().CheckMove(move,isCheckMateAllowed))
                availableMoves.add(move);
        }
        return availableMoves;
    }
    public Piece getCopy(PiecesGroup group, Game gameObj) {
        return new Rook(group,gameObj).setFirstMove(this.isFirstMove()).setPiecePosition(this.getPiecePosition());
    }
}
