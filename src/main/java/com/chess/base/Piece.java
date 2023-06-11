package com.chess.base;

public abstract class Piece {
    private PiecesGroup Group;
    private Objects.Position PiecePosition;
    private boolean FirstMove;
    private Objects.ChessPieces PieceType;

    public abstract int getPieceValue();
    //public abstract ArrayList<AllEnums.Move> AvailableMoves();


    public Objects.ChessPieces getPieceType() {
        return PieceType;
    }

    public PiecesGroup getGroup() {
        return Group;
    }

    public Objects.Position getPiecePosition() {
        return PiecePosition;
    }

    public boolean isFirstMove() {
        return FirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        FirstMove = firstMove;
    }

    protected void setGroup(PiecesGroup group) {
        Group = group;
    }

    public void setPiecePosition(Objects.Position piecePosition) {
        PiecePosition = piecePosition;
    }

    protected void setPieceType(Objects.ChessPieces pieceType) {
        PieceType = pieceType;
    }
}
