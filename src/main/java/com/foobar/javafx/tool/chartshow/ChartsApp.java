package com.foobar.javafx.tool.chartshow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Boyce on 16/3/17.
 */
public class ChartsApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(1000);
        scrollPane.setPrefHeight(618);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        FlowPane pane = new FlowPane();
        pane.setPrefWidth(1000);
        pane.setPrefHeight(618);
        pane.setHgap(10);

        scrollPane.setContent(pane);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Stock Monitoring, 2010");
        lineChart.setLayoutX(14);
        lineChart.setLayoutY(15);
        lineChart.setPrefWidth(974);
        lineChart.setPrefHeight(595);
        changeChart1(lineChart);

        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        xAxis.setLabel("Number of Month2");
        //creating the chart
        final LineChart<String,Number> lineChart2 =
                new LineChart<String,Number>(xAxis2,yAxis2);
        lineChart2.setTitle("Stock Monitoring2, 2010");
        lineChart2.setPrefWidth(974);
        lineChart2.setPrefHeight(595);

        changeChart1(lineChart2);

        pane.getChildren().add(lineChart);
        pane.getChildren().add(lineChart2);

        Scene scene = new Scene(scrollPane, 1000, 618);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Charts");
        primaryStage.show();
    }

    private void changeChart1(LineChart lineChart) {
        lineChart.setTitle("Stock Monitoring, 2010");
//        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
//        //populating the series with data
        series.getData().add(new XYChart.Data("1", 23));
        series.getData().add(new XYChart.Data("2", 14));
        series.getData().add(new XYChart.Data("3", 15));
        series.getData().add(new XYChart.Data("4", 24));
        series.getData().add(new XYChart.Data("5", 34));
        series.getData().add(new XYChart.Data("6", 36));
        series.getData().add(new XYChart.Data("7", 22));
        series.getData().add(new XYChart.Data("8", 45));
        series.getData().add(new XYChart.Data("9", 43));
        series.getData().add(new XYChart.Data("10", 17));
        series.getData().add(new XYChart.Data("11", 29));
        series.getData().add(new XYChart.Data("12", 25));
//
        lineChart.getData().add(series);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
