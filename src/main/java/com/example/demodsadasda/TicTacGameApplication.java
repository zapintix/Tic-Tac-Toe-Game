package com.example.demodsadasda;

import com.example.demodsadasda.logic.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.GridPane;

import javafx.stage.Stage;



public class TicTacGameApplication extends Application {
    private final GameAlert notification = new GameAlert();
    private Stage primaryStage;
    GameAlert.SizeInputDialogResult alert_result = notification.showSizeInputDialog(primaryStage);
    private final int gamemode = alert_result.getGameMode();
    private final int SIZE = alert_result.getSize();
    private final Board board = new Board(SIZE);
    private  Button[][] buttons = new Button[SIZE][SIZE];
    private Player player1;
    private Player player2;
    private Player player3;
    private final GridPane grid = new GridPane();


    private Button createButton(int row, int col) {
        Button button = new Button();
        button.setMinSize(100, 100);
        button.setStyle("-fx-font-size: 24; -fx-background-color: white; -fx-border-color: #afafaf; -fx-border-radius: 10px;-fx-border-width: 5px;-fx-font-family: 'Red October';");
        button.setOnAction(event -> handleButtonClick(button, row, col));
        return button;
    }

    @Override
    public void start(Stage primaryStage) {
        initializeBoard();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col] = createButton(row, col);
                grid.add(buttons[row][col], col, row);
            }
        }

        if (gamemode == 1){
            this.player1 = new HumanPlayer('X');
            this.player2 = new ComputerPlayer('O',SIZE);
        }
        else if (gamemode == 2){
            this.player1 = new HumanPlayer('X');
            this.player2 = new HumanPlayer('O');
        } else if (gamemode == 3){
            this.player1 = new HumanPlayer('X');
            this.player2 = new HumanPlayer('O');

        }

        player1.swith();


        Scene scene = new Scene(grid, 300, 300);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Tic Tac Toe");
        this.primaryStage.setScene(scene);
        this.primaryStage.setFullScreen(true);
        this.primaryStage.show();
    }

    private void initializeBoard() {
        Button[][] buttons = new Button[SIZE][SIZE];
    }

    private void handleButtonClick(Button button, int row, int col) {
        boolean player1_has_place =false;

        if (player1.getActive() && player1.makeMove(board, row, col)) {
            button.setText(String.valueOf(player1.symbol));
            checkwin(player1.symbol);
            player2.swith();
            player1_has_place = true;
        }
        if (player2.getType() == 'h'){
            if (player2.getActive() && player2.makeMove(board, row, col) && !player1_has_place) {
                button.setText(String.valueOf(player2.symbol));
                checkwin(player2.symbol);
                player1.swith();
            }
        }
        else {
            if (player2.getActive() && player2.makeMove(board, row, col)) {
                checkwin(player2.symbol);
                player1.swith();

            }
            RefreshButton();
        }
    }

    private void RefreshButton(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setText(String.valueOf(board.cells[row][col]));
            }
        }
    }

    private void checkwin(char symbol){
        if (board.isFull()){
            announceDraw();
            resetgame();
        }
        if (board.hasWinner()){
            if (player3 == null || player3.getType() != 'n') {
                announceWinner(symbol);
                resetgame();
            } else {
                board.clear();
                RefreshButton();
                player1.swith();
                player2.swith();
            }
        }
    }




    public void announceWinner(char currentPlayer) {
        notification.showWinnerAlert(String.valueOf(currentPlayer));
        primaryStage.close();
    }

    public void announceDraw() {
        notification.showWinnerAlert("Ничья");
        primaryStage.close();
    }
    public void resetgame(){
        initializeBoard();
        board.clear();
    }
    public static void main(String[] args) {
        launch(args);
    }

}