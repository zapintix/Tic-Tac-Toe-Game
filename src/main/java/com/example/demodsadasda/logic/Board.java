package com.example.demodsadasda.logic;

public class Board implements GameBoard {
    public char[][] cells;
    final int size;

    public Board(int size) {
        this.size=size;
        cells = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void placeSymbol(int row, int column, char symbol) {
        // Размещение символа на указанных координатах на игровой доске
        cells[row][column] = symbol;
    }

    public boolean isCellEmpty(int row, int column) {
        // Проверка, пустая ли клетка на указанных координатах
        return cells[row][column] != ' ';
    }
    public boolean hasWinner() {
        // Проверка на наличие победителя
        // (здесь реализуется соответствующая логика для определения победы по правилам "Крестики-нолики")

        // Проверка по горизонтали
        for (int i = 0; i < size; i++) {
            if (cells[i][0] != ' ') {
                boolean isWinner = true;
                for (int j = 1; j < size; j++) {
                    if (cells[i][j] != cells[i][0]) {
                        isWinner = false;
                        break;
                    }
                }
                if (isWinner) {
                    return true;
                }
            }
        }

        // Проверка по вертикали
        for (int i = 0; i < size; i++) {
            if (cells[0][i] != ' ') {
                boolean isWinner = true;
                for (int j = 1; j < size; j++) {
                    if (cells[j][i] != cells[0][i]) {
                        isWinner = false;
                        break;
                    }
                }
                if (isWinner) {
                    return true;
                }
            }
        }

        // Проверка по диагонали (левая верхняя - правая нижняя)
        if (cells[0][0] != ' ') {
            boolean isWinner = true;
            for (int i = 1; i < size; i++) {
                if (cells[i][i] != cells[0][0]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }

        // Проверка по диагонали (правая верхняя - левая нижняя)
        if (cells[0][size-1] != ' ') {
            boolean isWinner = true;
            for (int i = 1; i < size; i++) {
                if (cells[i][size-1-i] != cells[0][size-1]) {
                    isWinner = false;
                    break;
                }
            }
            return isWinner;
        }

        return false;
    }
    public boolean isFull() {
        // Проверка на заполненность доски
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public void clear(){
        cells = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return size;
    }
}

