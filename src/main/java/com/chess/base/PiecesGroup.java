package com.chess.base;

import java.util.ArrayList;

public abstract class PiecesGroup {
    public Objects.PiecesColor Color;
    private ArrayList<Piece> Pieces;
    private Game game;
    public PiecesGroup(Objects.PiecesColor color, Game game) {
        this.Color = color;
        this.game = game;
    }
    public Objects.PiecesColor getColor() {
        return Color;
    }
    public ArrayList<Objects.Move> getPieceGroupAvailableMoves(boolean isCheckMateAllowed) {
        ArrayList<Objects.Move> moves = new ArrayList<>();
        for (Piece pic:getPieces())
            moves.addAll(pic.AvailableMoves(isCheckMateAllowed));
        return moves;
    }
    public boolean isMate() {
        for (Objects.Move mov:OppositeSide().getPieceGroupAvailableMoves(false)) // call func with "true" arg to avoid infinity loop between isMate and CheckMove
            if (mov.getDestination().equals(getKing().getPiecePosition()))
                return true;
        return false;
    }


    public abstract PiecesGroup OppositeSide();

    public boolean CheckMate()
    {
        return isMate() && getKing().AvailableMoves(true).isEmpty();
    }

    public Piece getKing()
    {
        return getCustomPieces(Objects.ChessPieces.King).get(0);
    }
    public ArrayList<Piece> getCustomPieces(Objects.ChessPieces type)
    {
        ArrayList<Piece> pics = new ArrayList<>();
        for (Piece pic:getPieces())
            if (pic.getPieceType() == type)
                pics.add(pic);
        return pics;
    }
    public boolean AddPieceToGroup(Piece pic) {
        game.setPieceByPosition(pic.getPiecePosition(), pic);
       return Pieces.add(pic);
    }
    public boolean RemovePieceFromGroup(Piece pic) {
        return Pieces.remove(pic);
    }
    public ArrayList<Piece> getPieces() {
        return Pieces;
    }

    public Game getGame() {
        return game;
    }
}
