package fi.tuni.prog3.calc;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");
        
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 150);
        
        TextField fieldOp1 = new TextField();
        fieldOp1.setId("fieldOp1");
        grid.add(fieldOp1, 1, 1);
        
        TextField fieldOp2 = new TextField();
        fieldOp2.setId("fieldOp2");
        grid.add(fieldOp2, 1, 2);
        
        Label labelOp1 = new Label("First operand:");
        labelOp1.setId("labelOp1");
        grid.add(labelOp1, 0, 1);
        
        Label labelOp2 = new Label("Second operand:");
        labelOp2.setId("labelOp2");
        grid.add(labelOp2, 0, 2);
       
        HBox hbBtn = new HBox(10);
        grid.add(hbBtn, 1, 3);
        
        Button btnAdd = new Button("Add");
        btnAdd.setId("btnAdd");
        hbBtn.getChildren().add(btnAdd);
        
        Button btnSub = new Button("Subtract");
        btnSub.setId("btnSub");
        hbBtn.getChildren().add(btnSub);
        
        Button btnMul = new Button("Multiply");
        btnMul.setId("btnMul");
        hbBtn.getChildren().add(btnMul);
        
        Button btnDiv = new Button("Divide");
        btnDiv.setId("btnDiv");
        hbBtn.getChildren().add(btnDiv);
        
        Label fieldRes = new Label();
        fieldRes.setId("fieldRes");
        fieldRes.setBackground(new Background(new BackgroundFill(Color.WHITE, 
                null, null)));
        grid.add(fieldRes, 1, 4);
        
        Label labelRes = new Label("Result:");
        labelRes.setId("labelRes");
        grid.add(labelRes, 0, 4);
        
        
        btnAdd.setOnAction((ActionEvent e) -> {
            var x = Double.parseDouble(fieldOp1.getText());
            var y = Double.parseDouble(fieldOp2.getText());
            var z = x + y;
            DecimalFormat format = new DecimalFormat("0.####");
            format.setMinimumFractionDigits(1);
            fieldRes.setText(format.format(z));

        });
        
        btnSub.setOnAction((ActionEvent e) -> {
            var x = Double.parseDouble(fieldOp1.getText());
            var y = Double.parseDouble(fieldOp2.getText());
            var z = x - y;
            DecimalFormat format = new DecimalFormat("0.####");
            format.setMinimumFractionDigits(1);
            fieldRes.setText(format.format(z));
        });
        
        btnMul.setOnAction((ActionEvent e) -> {
            var x = Double.parseDouble(fieldOp1.getText());
            var y = Double.parseDouble(fieldOp2.getText());
            var z = x * y;
            DecimalFormat format = new DecimalFormat("0.####");
            format.setMinimumFractionDigits(1);
            fieldRes.setText(format.format(z));
        });
        
        btnDiv.setOnAction((ActionEvent e) -> {
            var x = Double.parseDouble(fieldOp1.getText());
            var y = Double.parseDouble(fieldOp2.getText());
            var z = x / y;
            DecimalFormat format = new DecimalFormat("0.####");
            format.setMinimumFractionDigits(1);
            fieldRes.setText(format.format(z));
        });
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}