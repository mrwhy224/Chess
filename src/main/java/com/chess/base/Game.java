package com.chess.base;

public class Game {

    private Piece[][] pieces = new Piece[8][8];
    public PiecesGroup WhitePieces;
    public PiecesGroup BlackPieces;
    public Objects.PiecesColor CurrentTurn;

    /*
    public void DefaultSetup() {

    }
    public void CustomSetup() {

    }
    */
    public boolean CheckMove(Objects.Move move) {
        if(move.getDestination() == move.getOrigin()) // there is no movement
            return false;
        if(move.getOrigin() != move.getPiece().getPiecePosition()) // origin position must be based on current piece position
            return false;
        // toDo: check logically piece movement
        return true;
    }
    public void ApplyMove(Objects.Move move) {
        if (CheckMove(move))
        {
            move.getPiece().setPiecePosition(move.getDestination());
            move.getPiece().setFirstMove(false);
            setPieceByPosition(move.getOrigin(),null);
            if(!java.util.Objects.isNull(getPieceByPosition(move.getDestination())))
                getPieceByPosition(move.getDestination()).getGroup().RemovePieceFromGroup(getPieceByPosition(move.getDestination()));
            setPieceByPosition(move.getDestination(),move.getPiece());
        }
    }
    public Piece getPieceByPosition(Objects.Position position) {
        return pieces[position.getX()][position.getY()];
    }

    public void setPieceByPosition(Objects.Position position, Piece piece)
    {
        pieces[position.getX()][position.getY()] = piece;
    }
}
