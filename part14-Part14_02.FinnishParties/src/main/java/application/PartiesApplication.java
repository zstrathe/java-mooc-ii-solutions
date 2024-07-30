package application;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Arrays;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        xAxis.setLabel("Year");
        xAxis.setLabel("Relative Support (%)");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of Parties");
        
        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            String[] headerRow = scanner.nextLine().split("\t");

            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split("\t");
     
                XYChart.Series lineData = new XYChart.Series();
                lineData.setName(String.valueOf(row[0]));
                
                // iterate through the row values and add to Series obj
                for (int col = 1; col < row.length; col++) {
                    // use try-catch block to filter out values that cannot be converted to Double
                    try {
                        Double rowVal = Double.valueOf(row[col]);
                        lineData.getData().add(new XYChart.Data(Integer.valueOf(headerRow[col]), rowVal));
                    } catch (Exception de) {
                        System.out.println("Error converting to double...skipping col: " + row[col]);
                    }
                }
                lineChart.getData().add(lineData);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
    }
}
