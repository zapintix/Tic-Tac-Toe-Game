package com.example.demodsadasda;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Objects;

public class GameAlert {

    public class SizeInputDialogResult {
        private final int size;
        private final int gameMode;

        public SizeInputDialogResult(int size, int gameMode) {
            this.size = size;
            this.gameMode = gameMode;
        }

        public int getSize() {
            return size;
        }

        public int getGameMode() {
            return gameMode;
        }
    }

    public SizeInputDialogResult showSizeInputDialog(Stage primaryStage) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Введите размер");
        alert.setHeaderText("Размер для доски:");

        Label label = new Label("Размер:");
        TextField sizeField = new TextField();
        sizeField.setPromptText("Введите размер");

        Label label2 = new Label("Выберите режим (1 - Компьютер, 2 - Друг):");
        TextField sizeField2 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label, 1, 1);
        grid.add(sizeField, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(sizeField2, 2, 2);

        grid.setStyle("-fx-background-color: white");
        alert.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Ок");
        ButtonType buttonTypeCancel = new ButtonType("Отмена");

        alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);

        alert.initOwner(primaryStage);

        alert.showAndWait();

        if (alert.getResult() == buttonTypeOk) {
             try {
                int size = Integer.parseInt(sizeField.getText());
                int gameMode = Integer.parseInt(sizeField2.getText());
                return new SizeInputDialogResult(size, gameMode);
            } catch (NumberFormatException e) {
                //pass
            }
        }
        return null; // Если пользователь нажал "Отмена" или была ошибка ввода
    }
    public  void showWinnerAlert(String winnerSymbol) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Player " + winnerSymbol + " wins!");
        alert.setContentText("Congratulations!");
        alert.showAndWait();
    }
}
