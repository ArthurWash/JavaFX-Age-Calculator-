package com.homework7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
 * Arthur Wash
 * Java Programming (CS602)
 * NJIT
 * Homework 7
 */

public class FXAgeCalculator extends Application {
    @Override
    public void start(Stage primaryStage){
        // Label Creation
        Label pickLabel = new Label("Pick Jane's birth date");
        pickLabel.setFont(new Font("Eurostile", 14));
        pickLabel.setTextFill(Color.LIGHTGRAY);
        pickLabel.setTranslateY(100);

        Label resultLabel = new Label();
        resultLabel.setFont(new Font("Eurostile", 14));
        resultLabel.setTextFill(Color.LIGHTGREY);
        resultLabel.setTranslateY(-50);

        // DatePicker Object Creation
        DatePicker dp = new DatePicker();

        // Event Handler
        dp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                LocalDate dateSelected = dp.getValue();
                LocalDateTime currentDate = LocalDateTime.now();
                long result = ChronoUnit.YEARS.between(dateSelected, currentDate);
                resultLabel.setText("Jane is " + result + " years old.");
            }
        });

        // BorderPane setup
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: BLACK");
        pane.setTop(pickLabel);
        pane.setCenter(dp);
        pane.setBottom(resultLabel);
        BorderPane.setAlignment(pickLabel, Pos.TOP_CENTER);
        BorderPane.setAlignment(resultLabel, Pos.BOTTOM_CENTER);
        
        // Scene setup
        Scene scene = new Scene(pane, 400, 600);

        // CSS Stylesheet
        scene.getStylesheets().add(this.getClass().getResource("Style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Homework 7: How old is Jane?");
        primaryStage.show();
    }

    // Main method
    public static void main(String[] args){
        launch();
    }
}
