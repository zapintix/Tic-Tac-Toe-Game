package com.example.demodsadasda.logic;

public class HumanPlayer extends Player{
    public HumanPlayer(char symbol) {
        super(symbol);
        this.type = 'h';
    }

    @Override
    public boolean makeMove(Board board, int row, int col) {
       if (board.isCellEmpty(row, col)) {
           return false;
       }
       else {
           board.placeSymbol(row, col, symbol);
           swith();
           return true;
       }
    }
}
