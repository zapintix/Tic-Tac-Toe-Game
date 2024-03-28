package com.example.demodsadasda.logic;

public interface GameBoard {
    void placeSymbol(int row, int column, char symbol);
    boolean isCellEmpty(int row, int column);
    boolean hasWinner();
    boolean isFull();
    void clear();
    int getSize();
}
