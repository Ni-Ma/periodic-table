/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodictable;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author nmartin
 */
public class PeriodicTable extends Application {
    
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();
        
        TableGui gui = new TableGui(grid);        
        
        final Scene scene = new Scene(grid, 1000, 650);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}