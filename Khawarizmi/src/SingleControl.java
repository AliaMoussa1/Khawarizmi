
import Algorithms.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SingleControl {
    @FXML
    private Button backBtn;
    @FXML
    private Label worstNotation;
    @FXML
    private Label extraLabel;
    @FXML
    private LineChart<String, Double> AlgoChart;
    @FXML
    private Button countingBtn;
    @FXML
    private Button heapBtn;
    @FXML
    private Button insertionBtn;
    @FXML
    private Button mergeBtn;
    @FXML
    private Button quickBtn;
    @FXML
    private Button radixBtn;
    @FXML
    private Button selectionBtn;


    @FXML
    void backToMain(MouseEvent event) throws IOException {
        Stage singleStage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        singleStage.setTitle("Khawarizmi");
        singleStage .setScene(new Scene(root));
    }


    @FXML
    void graphInsertion(MouseEvent event) throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> insertion = new XYChart.Series<String, Double>();
        Insertion ab = new Insertion();
        ab.createFile();

        for (int i=10; i<=1000; i+=10) //for x= no of elements i, y = no of steps for sorting i elements using this algo
            insertion.getData().add(new XYChart.Data<>(String.valueOf(i), ab.sort(i)));
        insertion.setName("Actual Sorting Time");

        //Average Case Asymptotic efficiency
        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), Math.pow(i,2)));
        worst.setName("Average Case Time Complexity");

        //Best Case Asymptotic efficiency
        XYChart.Series<String, Double> best = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            best.getData().add(new XYChart.Data<>(String.valueOf(i), Double.valueOf(i)));
        best.setName("Best Case Time Complexity");

        AlgoChart.getData().addAll(insertion, worst, best);

        worstNotation.setText("Average and Worst Case time complexity of Insertion Sort is Θ(n^2)");
        extraLabel.setText("Best case time complexity of Insertion Sort is Θ(n)");
    }


    @FXML
    void graphCounting(MouseEvent event)throws FileNotFoundException {
        AlgoChart.getData().clear();
        XYChart.Series<String, Double> counting = new XYChart.Series<String, Double>();
        Counting z = new Counting();
        z.createFile();

        for (int i=10; i<=1000; i+=10)
            counting.getData().add(new XYChart.Data<>(String.valueOf(i), z.sort(i)));
        counting.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), Double.valueOf(i)));
        worst.setName("Average Case Time Complexity");

        AlgoChart.getData().addAll(counting, worst);

        worstNotation.setText("Average and Worst Case running time of Counting Sort algorithm is O(n+k)");
        extraLabel.setText("Where n is the number of elements in the array and k is max element");
    }


    @FXML
    void graphHeap(MouseEvent event)throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> heap = new XYChart.Series<String, Double>();
        Heap h = new Heap();
        h.createFile();

        for (int i=10; i<=1000; i+=10)
            heap.getData().add(new XYChart.Data<>(String.valueOf(i), h.sort(i)));
        heap.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), i * (Math.log(i) / Math.log(2))));
        worst.setName("Worst Case Time Complexity");
        AlgoChart.getData().addAll(heap, worst);

        worstNotation.setText("Worst, Average and Best time complexity of Heap Sort is Θ(nlogn)");
        extraLabel.setText(" ");

    }


    @FXML
    void graphMerge(MouseEvent event) throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> merge = new XYChart.Series<String, Double>();
        Merge m = new Merge();
        m.createFile();

        for (int i=10; i<=1000; i+=10)
            merge.getData().add(new XYChart.Data<>(String.valueOf(i), m.sort(i)));
        merge.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), i * (Math.log(i) / Math.log(2))));
        worst.setName("Average Case Time Complexity");


        AlgoChart.getData().addAll(merge, worst);

        worstNotation.setText("Average, Best and Worst Case time complexity of Merge Sort is Θ(nlogn)");
        extraLabel.setText(" ");
    }


    @FXML
    void graphQuick(MouseEvent event) throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> quick = new XYChart.Series<String, Double>();
        Quick q = new Quick();
        q.createFile();

        for (int i=10; i<=1000; i+=10)
            quick.getData().add(new XYChart.Data<>(String.valueOf(i), q.sort(i)));
        quick.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), Math.pow(i,2)));
        worst.setName("Worst Case Time Complexity");

        XYChart.Series<String, Double> best = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            best.getData().add(new XYChart.Data<>(String.valueOf(i), i * (Math.log(i) / Math.log(2))));
        best.setName("Average Case Time Complexity");

        AlgoChart.getData().addAll(quick,worst, best);

        worstNotation.setText("Worst Case time complexity of Quick Sort is Θ(n^2)");
        extraLabel.setText("Average case time complexity of Quick Sort is Θ(nlogn)");
    }

    @FXML
    void graphRadix(MouseEvent event) throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> insertion = new XYChart.Series<String, Double>();
        Radix r = new Radix();
        r.createFile();

        for (int i=10; i<=1000; i+=10)
            insertion.getData().add(new XYChart.Data<>(String.valueOf(i), r.sort(i)));
        insertion.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), 3*(Double.valueOf(i) + 10)));
        worst.setName("Worst Case Time Complexity");

        AlgoChart.getData().addAll(insertion, worst);

        worstNotation.setText("Average and Worst Case time complexity of Radix Sort is Θ(d(k+n), where ");
        extraLabel.setText("d is the number of digits and k is the base used, in this case 3 & 10 respectively");
    }

    @FXML
    void graphSelection(MouseEvent event) throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> selection = new XYChart.Series<String, Double>();
        Selection s = new Selection();
        s.createFile();

        for (int i=10; i<=1000; i+=10)
            selection.getData().add(new XYChart.Data<>(String.valueOf(i), s.sort(i)));
        selection.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), Math.pow(i,2)));
        worst.setName("Average Case Time Complexity");



        AlgoChart.getData().addAll(selection, worst);

        worstNotation.setText("Average, Worst, and Best Case time complexity of Selection Sort is Θ(n^2)");
        extraLabel.setText(" ");
    }

    @FXML
    void graphBubble(MouseEvent event)throws FileNotFoundException {
        AlgoChart.getData().clear();

        XYChart.Series<String, Double> bubble = new XYChart.Series<String, Double>();
        Bubble b = new Bubble();
        b.createFile();

        for (int i=10; i<=1000; i+=10)
            bubble.getData().add(new XYChart.Data<>(String.valueOf(i), b.sort(i)));
        bubble.setName("Actual Sorting Time");


        XYChart.Series<String, Double> worst = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            worst.getData().add(new XYChart.Data<>(String.valueOf(i), Math.pow(i,2)));
        worst.setName("Worst Case Time Complexity");

        XYChart.Series<String, Double> best = new XYChart.Series<String, Double>();
        for (int i=10; i<=1000; i+=10)
            best.getData().add(new XYChart.Data<>(String.valueOf(i), Double.valueOf(i)));
        best.setName("Best Case Time Complexity");

        AlgoChart.getData().addAll(bubble, worst, best);

        worstNotation.setText("Average and Worst Case time complexity of Bubble Sort is Θ(n^2)");
        extraLabel.setText("Best case time complexity of Bubble Sort is Θ(n)");
    }

}
