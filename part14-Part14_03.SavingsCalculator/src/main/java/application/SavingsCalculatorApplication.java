package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        // define main layout BorderPane
        BorderPane mainLayout = new BorderPane();

        // define the monthly savings slider inside of a BorderPane
        BorderPane monthlySavingsSliderLayout = new BorderPane();
        Label monthlySavingsLabel = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25,250,0);
        Label monthlySavingsSliderValue = new Label(Double.toString(monthlySavingsSlider.getValue()));
        monthlySavingsSlider.setMajorTickUnit(25);
//        monthlySavingsSlider.setSnapToTicks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSliderLayout.setLeft(monthlySavingsLabel);
        monthlySavingsSliderLayout.setCenter(monthlySavingsSlider);
        monthlySavingsSliderLayout.setRight(monthlySavingsSliderValue);
        
        // define the monthly savings slider inside of a BorderPane
        BorderPane interestRateSliderLayout = new BorderPane();
        Label interestRateLabel = new Label("Yearly interest rate");
        Slider interestRateSlider = new Slider(0,10,0);
        Label interestRateSliderValue = new Label(String.valueOf(interestRateSlider.getValue()));
        interestRateSlider.setMajorTickUnit(10);
        interestRateSlider.setMinorTickCount(100);
//        interestRateSlider.setSnapToTicks(true);
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setShowTickMarks(true);
        interestRateSliderLayout.setLeft(interestRateLabel);
        interestRateSliderLayout.setCenter(interestRateSlider);
        interestRateSliderLayout.setRight(interestRateSliderValue);
        
        // put the sliders inside of a VBox
        VBox slidersLayout = new VBox();
        slidersLayout.setAlignment(Pos.CENTER);
        slidersLayout.setSpacing(35);
        slidersLayout.setPadding(new Insets(20, 20 , 20, 20));
        slidersLayout.getChildren().addAll(monthlySavingsSliderLayout, interestRateSliderLayout);
        mainLayout.setTop(slidersLayout);
        
        // define LineChart and components
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
      
        // updates based on savings amount slider
        monthlySavingsSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    monthlySavingsSliderValue.setText(String.format("%.0f", new_val));
                    XYChart.Series savingsData = generateData(new_val, 30);
                    XYChart.Series interestData = generateCompoundedData(new_val, interestRateSlider.getValue(), 30);
                    lineChart.getData().clear();
                    lineChart.getData().add(savingsData);
                    lineChart.getData().add(interestData);
            }
        });
        
        // updates based on interest rate slider
        interestRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    interestRateSliderValue.setText(String.format("%.1f", new_val));
                    XYChart.Series savingsData = generateData(monthlySavingsSlider.getValue(), 30);
                    XYChart.Series interestData = generateCompoundedData(monthlySavingsSlider.getValue(), new_val, 30);
                    lineChart.getData().clear();
                    lineChart.getData().add(savingsData);
                    lineChart.getData().add(interestData);
            }
        });
      
        // set the Scene and show window
        Scene scene = new Scene(mainLayout, 640, 480);
        window.setScene(scene);
        window.show();
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setTitle("Projected Savings Balance");
        mainLayout.setCenter(lineChart);
    }
        
    public XYChart.Series generateData(Number monthlySavings, int nPeriods) {
        XYChart.Series lineData = new XYChart.Series();
        lineData.setName("savings");
        for (int period = 0; period < nPeriods+1; period++) {
            lineData.getData().add(new XYChart.Data(period, (double)monthlySavings*12.0*period));
        }
        return lineData;
    }
     public XYChart.Series generateCompoundedData(Number monthlySavings, Number interestRate, int nPeriods) {
        XYChart.Series lineData = new XYChart.Series();
        lineData.setName("compounded");
        double savingsCompoundedValue = 0.0;
        for (int period = 0; period < nPeriods+1; period++) {
            savingsCompoundedValue = savingsCompoundedValue * (1 + ((double)interestRate/100));
            lineData.getData().add(new XYChart.Data(period, savingsCompoundedValue));
            savingsCompoundedValue += (double) monthlySavings*12;
        }
        return lineData;
    }
    
    

}
