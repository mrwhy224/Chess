package com.chess.base;

public class BlackPieceGroup extends PiecesGroup{
    public BlackPieceGroup(Game game) {
        super(Objects.PiecesColor.Black, game);
    }
    public PiecesGroup OppositeSide() {
        return getGame().getWhitePieces();
    }
}
