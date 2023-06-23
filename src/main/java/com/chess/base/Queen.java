package com.chess.base;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(PiecesGroup group, Game gameObj) {
        super(Objects.ChessPieces.Queen, group, gameObj, 9);
    }
    public ArrayList<Objects.Move> AvailableMoves(boolean isCheckMateAllowed) {
        ArrayList<Objects.Move> availableMoves = new ArrayList<>();

        for (int i=-this.getPiecePosition().getX(); i<8-this.getPiecePosition().getX(); i++)
            for (int j=-this.getPiecePosition().getY(); j<8-this.getPiecePosition().getY(); j++)
                if(i==0 || j==0 || abs(this.getPiecePosition().getX()+i)==abs(this.getPiecePosition().getY()+j))
                {
                    boolean att = false;
                    Objects.Position newPosition = new Objects.Position(this.getPiecePosition().getX()+i, this.getPiecePosition().getY()+j);
                    if (!java.util.Objects.isNull(this.getGameObj().getPieceByPosition(newPosition)) && this.getGameObj().getPieceByPosition(newPosition).getGroup() != this.getGroup())
                        att = true;
                    Objects.Move move = new Objects.Move(this, this.getPiecePosition(), newPosition, att);
                    if(this.getGameObj().CheckMove(move,isCheckMateAllowed))
                        availableMoves.add(move);
                }
        return availableMoves;
    }
    public Piece createCopy(PiecesGroup group, Game gameObj) {
        return new Queen(group,gameObj).setFirstMove(this.isFirstMove()).setPiecePosition(this.getPiecePosition());
    }
}
