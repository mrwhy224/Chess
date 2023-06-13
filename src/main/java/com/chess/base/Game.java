package com.chess.base;

import static java.lang.Math.*;

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
        Objects.Position pieceChanges = new Objects.Position(abs(move.getDestination().getX() - move.getOrigin().getX()), abs(move.getDestination().getY() - move.getOrigin().getY()));
        if (move.getDestination() == move.getOrigin()) // there is no movement
            return false;
        if (move.getOrigin() != move.getPiece().getPiecePosition()) // origin position must be based on current piece position
            return false;

        if (pieceChanges.getX() > 1 && pieceChanges.getY() == 0) // The length of the move is more than one house on the x-axis, and it must be checked that no other piece is in the way
            for (int x = min(move.getDestination().getX(), move.getOrigin().getX()) + 1; x < max(move.getDestination().getX(), move.getOrigin().getX()); x++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(x, move.getOrigin().getY()))))
                    return false;

        if (pieceChanges.getX() == 0 && pieceChanges.getY() > 1) // The length of the move is more than one house on the y-axis, and it must be checked that no other piece is in the way
            for (int y= min(move.getDestination().getY(), move.getOrigin().getY()) + 1; y < max(move.getDestination().getY(), move.getOrigin().getY()); y++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(move.getOrigin().getX(), y))))
                    return false;
        if(pieceChanges.getX() > 1 && pieceChanges.getY() > 1) // The length of the move is more than one house on the diagonal-axis, and it must be checked that no other piece is in the way
            for (int z= 1; z < abs(pieceChanges.getX()); z++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(min(move.getDestination().getX(), move.getOrigin().getX())+z, min(move.getDestination().getY(), move.getOrigin().getY())+z))))
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
