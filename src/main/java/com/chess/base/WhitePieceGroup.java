package com.chess.base;

public class WhitePieceGroup extends PiecesGroup{
    public WhitePieceGroup(Game game) {
        super(Objects.PiecesColor.White, game);
    }
    public boolean isMate() {
        for (Objects.Move mov:getGame().BlackPieces.getPieceGroupAvailableMoves())
            if (mov.getDestination().equals(getKing().getPiecePosition()))
                return true;
        return false;
    }
}
