package com.example.demodsadasda.logic;

public abstract class Player {
    public char symbol;
    private boolean activity = false;
    protected char type;
    protected int row;
    protected int col;
    protected int score;
    public Player(char symbol) {
        this.symbol = symbol;
    }

    public abstract boolean makeMove(Board board, int row, int col);

    public boolean getActive(){
        return activity;
    }
    public void swith(){
        this.activity = !this.activity;
    }
    public char getType(){
        return type;
    }



}


