package com.chess.base;

import java.util.ArrayList;

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
    public abstract ArrayList<Objects.Move> AvailableMoves(boolean isCheckMateAllowed);
    public abstract Piece getCopy(PiecesGroup Group, Game GameObj);
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
    public Piece setFirstMove(boolean firstMove) {
        FirstMove = firstMove;
        return this;
    }
    public Piece setPiecePosition(Objects.Position piecePosition) {
        PiecePosition = piecePosition;
        return this;
    }
}
