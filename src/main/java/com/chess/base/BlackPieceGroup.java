package com.chess.base;

public class BlackPieceGroup extends PiecesGroup{
    public BlackPieceGroup(Game game) {
        super(Objects.PiecesColor.Black, game);
    }
    public boolean isMate() {
        for (Objects.Move mov:getGame().WhitePieces.getPieceGroupAvailableMoves())
            if (mov.getDestination().equals(getKing().getPiecePosition()))
                return true;
        return false;
    }
}
