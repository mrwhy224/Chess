package com.chess.base;

public abstract class Piece {
    private PiecesGroup Group;
    private Game GameObj;
    private Objects.Position PiecePosition;
    private boolean FirstMove;
    private Objects.ChessPieces PieceType;
    private int PieceValue;
    public Piece(Objects.ChessPieces pieceType, PiecesGroup group, Game gameObj, int pieceValue) {
        PieceType = pieceType;
        Group = group;
        GameObj = gameObj;
        PieceValue = pieceValue;
    }
    //public abstract ArrayList<AllEnums.Move> AvailableMoves();
    public int getPieceValue() {
        return PieceValue;
    }
    public Game getGameObj() {
        return GameObj;
    }
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
    public void setPiecePosition(Objects.Position piecePosition) {
        PiecePosition = piecePosition;
    }
}
