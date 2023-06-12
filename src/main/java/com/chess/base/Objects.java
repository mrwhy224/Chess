package com.chess.base;

public class Objects {
    public static enum PiecesColor {
        White,
        Black
    }
    public static enum HousesColor {
        White,
        Black
    }
    public static enum ChessPieces{
        King,
        Queen,
        Rook,
        Knight,
        Bishop,
        Pawn,
    }
    public static class Position{
        private int x;
        private int y;
        public Position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public String getChessHouseName() {
            switch (this.getX()) {
                case 0:
                    return "A"+(this.getY()+1);
                case 1:
                    return "B"+(this.getY()+1);
                case 2:
                    return "C"+(this.getY()+1);
                case 3:
                    return "D"+(this.getY()+1);
                case 4:
                    return "E"+(this.getY()+1);
                case 5:
                    return "F"+(this.getY()+1);
                case 6:
                    return "G"+(this.getY()+1);
                case 7:
                    return "H"+(this.getY()+1);
            }
            return null;
        }
    }
    public static class Move {
        private Position origin;
        private Position destination;
        private boolean attack;
        private Piece piece;
        public Move(Piece pic, Position org, Position des, boolean att)
        {
            piece = pic;
            origin = org;
            destination = des;
            attack = att;
        }
        public Piece getPiece() {
            return piece;
        }
        public Position getOrigin() {
            return origin;
        }
        public Position getDestination() {
            return destination;
        }
        public boolean isAttack() {
            return attack;
        }
    }
}
