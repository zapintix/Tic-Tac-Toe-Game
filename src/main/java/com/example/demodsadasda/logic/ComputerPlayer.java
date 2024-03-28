package com.example.demodsadasda.logic;

import java.util.Random;

public class ComputerPlayer extends Player{


    private final int size;
    public ComputerPlayer(char symbol, int size) {
        super(symbol);
        this.size = size;
        this.type = 'c';

    }

    @Override
    public boolean makeMove(Board board, int row, int col) {
        Random random = new Random();
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board.isCellEmpty(row, col));
        this.row = row;
        this.col = col;
        board.placeSymbol(row, col, symbol);
        swith();
        return true;
    }
}
