package com.chess.base;

import static java.lang.Math.*;

public class Game {

    private Piece[][] pieces = new Piece[8][8];
    private PiecesGroup WhitePieces;
    private PiecesGroup BlackPieces;
    private Objects.PiecesColor CurrentTurn;

    public Game() {
        WhitePieces = new WhitePieceGroup(this);
        BlackPieces = new BlackPieceGroup(this);

        for (int x=0;x<8;x++)
            for (int y=0;y<8;y++)
                pieces[x][y] = null;
    }
    public void DefaultSetup() {
        CurrentTurn = Objects.PiecesColor.White;

        for (int x=0; x<8; x++) { // setup pawn on the board
            WhitePieces.AddPieceToGroup(new Pawn(WhitePieces, this).setPiecePosition(new Objects.Position(x,1)).setFirstMove(true));
            BlackPieces.AddPieceToGroup(new Pawn(BlackPieces, this).setPiecePosition(new Objects.Position(x,6)).setFirstMove(true));
        }

        // setup rook on the board
        WhitePieces.AddPieceToGroup(new Rook(WhitePieces, this).setPiecePosition(new Objects.Position(0,0)).setFirstMove(true));
        WhitePieces.AddPieceToGroup(new Rook(WhitePieces, this).setPiecePosition(new Objects.Position(7,0)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Rook(BlackPieces, this).setPiecePosition(new Objects.Position(0,7)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Rook(BlackPieces, this).setPiecePosition(new Objects.Position(7,7)).setFirstMove(true));

        // setup knight on the board
        WhitePieces.AddPieceToGroup(new Knight(WhitePieces, this).setPiecePosition(new Objects.Position(1,0)).setFirstMove(true));
        WhitePieces.AddPieceToGroup(new Knight(WhitePieces, this).setPiecePosition(new Objects.Position(6,0)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Knight(BlackPieces, this).setPiecePosition(new Objects.Position(1,7)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Knight(BlackPieces, this).setPiecePosition(new Objects.Position(6,7)).setFirstMove(true));

        // setup bishop on the board
        WhitePieces.AddPieceToGroup(new Bishop(WhitePieces, this).setPiecePosition(new Objects.Position(2,0)).setFirstMove(true));
        WhitePieces.AddPieceToGroup(new Bishop(WhitePieces, this).setPiecePosition(new Objects.Position(5,0)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Bishop(BlackPieces, this).setPiecePosition(new Objects.Position(2,7)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Bishop(BlackPieces, this).setPiecePosition(new Objects.Position(5,7)).setFirstMove(true));


        WhitePieces.AddPieceToGroup(new Queen(WhitePieces, this).setPiecePosition(new Objects.Position(3,0)).setFirstMove(true));
        WhitePieces.AddPieceToGroup(new King(WhitePieces, this).setPiecePosition(new Objects.Position(4,0)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Queen(BlackPieces, this).setPiecePosition(new Objects.Position(3,7)).setFirstMove(true));
        BlackPieces.AddPieceToGroup(new Bishop(BlackPieces, this).setPiecePosition(new Objects.Position(4,7)).setFirstMove(true));

    }
    public Game getCopy() {
        Game game = new Game();
        game.CurrentTurn = this.CurrentTurn;
        for (Piece pic:this.WhitePieces.getPieces())
            game.WhitePieces.AddPieceToGroup(pic.getCopy(game.WhitePieces,game));
        for (Piece pic:this.BlackPieces.getPieces())
            game.BlackPieces.AddPieceToGroup(pic.getCopy(game.BlackPieces,game));
        return game;
    }
    /*
    public void Setup() {

    }
    */
    public boolean CheckMove(Objects.Move move, boolean isCheckMateAllowed) {

        Objects.Position pieceChanges = new Objects.Position(abs(move.getDestination().getX() - move.getOrigin().getX()), abs(move.getDestination().getY() - move.getOrigin().getY()));

        if (move.getDestination() == move.getOrigin()) // there is no movement
            return false;
        if (move.getOrigin() != move.getPiece().getPiecePosition()) // origin position must be based on current piece position
            return false;
        if(move.getDestination().getX()<0 || move.getDestination().getX()>7 || move.getDestination().getY()<0 || move.getDestination().getY()>7) // The correct position contains a number between 0 and 7
            return false;
        if(move.isAttack() && java.util.Objects.isNull(getPieceByPosition(move.getDestination())))
            return false;
        if(move.isAttack() && getPieceByPosition(move.getOrigin()).getGroup().Color == getPieceByPosition(move.getDestination()).getGroup().Color)
            return false;
        if(move.isAttack() || java.util.Objects.isNull(getPieceByPosition(move.getDestination())))
            return false;


        if (pieceChanges.getX() > 1 && pieceChanges.getY() == 0) // The length of the move is more than one house on the x-axis, and it must be checked that no other piece is in the way
            for (int x = min(move.getDestination().getX(), move.getOrigin().getX()) + 1; x < max(move.getDestination().getX(), move.getOrigin().getX()); x++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(x, move.getOrigin().getY()))))
                    return false;
        if (pieceChanges.getX() == 0 && pieceChanges.getY() > 1) // The length of the move is more than one house on the y-axis, and it must be checked that no other piece is in the way
            for (int y= min(move.getDestination().getY(), move.getOrigin().getY()) + 1; y < max(move.getDestination().getY(), move.getOrigin().getY()); y++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(move.getOrigin().getX(), y))))
                    return false;
        if(pieceChanges.getX() > 1 && pieceChanges.getY() > 1 && move.getPiece().getPieceType() != Objects.ChessPieces.Knight) // The length of the move is more than one house on the diagonal-axis, and it must be checked that no other piece is in the way
            for (int z= 1; z < abs(pieceChanges.getX()); z++)
                if (!java.util.Objects.isNull(getPieceByPosition(new Objects.Position(min(move.getDestination().getX(), move.getOrigin().getX())+z, min(move.getDestination().getY(), move.getOrigin().getY())+z))))
                    return false;
        // It checks whether that moves, its movement causes itself to be matted
        return !isCheckMateAllowed || !getCopy().ApplyMove(move).getCurrentTurn().OppositeSide().isMate();
    }
    public Game ApplyMove(Objects.Move move) {
        if (CheckMove(move,false))
        {
            move.getPiece().setPiecePosition(move.getDestination());
            move.getPiece().setFirstMove(false);
            setPieceByPosition(move.getOrigin(),null);
            if(!java.util.Objects.isNull(getPieceByPosition(move.getDestination())))
                getPieceByPosition(move.getDestination()).getGroup().RemovePieceFromGroup(getPieceByPosition(move.getDestination()));
            setPieceByPosition(move.getDestination(),move.getPiece());
            CurrentTurn = CurrentTurn == Objects.PiecesColor.White ? Objects.PiecesColor.Black : Objects.PiecesColor.White;
        }
        return this;
    }
    public PiecesGroup getCurrentTurn() {
        return CurrentTurn == Objects.PiecesColor.White ? WhitePieces:BlackPieces;
    }
    public PiecesGroup getBlackPieces() {
        return BlackPieces;
    }
    public PiecesGroup getWhitePieces() {
        return WhitePieces;
    }
    public Piece getPieceByPosition(Objects.Position position) {
        return pieces[position.getX()][position.getY()];
    }
    public void setPieceByPosition(Objects.Position position, Piece piece) {
        pieces[position.getX()][position.getY()] = piece;
    }
}
