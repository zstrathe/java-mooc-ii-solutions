package application;

import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Shanghai Ranking - University of Helsinki");
        
        HashMap<Number, Number> rankData = new HashMap<>() {{
            put(2007, 73);
            put(2008, 68);
            put(2009, 72);
            put(2010, 72);
            put(2011, 74);
            put(2012, 73);
            put(2013, 76);
            put(2014, 73);
            put(2015, 67);
            put(2016, 56);
            put(2017, 56);
        }};
        
        XYChart.Series data = new XYChart.Series();
        
        rankData.forEach((key, value) -> {
            data.getData().add(new XYChart.Data(key, value));
        });
        
        lineChart.getData().add(data);
        
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
    }
}
