package com.chess.base;

public class WhitePieceGroup extends PiecesGroup{
    public WhitePieceGroup(Game game) {
        super(Objects.PiecesColor.White, game);
    }
    public PiecesGroup OppositeSide() {
        return getGame().getBlackPieces();
    }
}
