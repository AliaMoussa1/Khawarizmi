import Algorithms.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Comparison implements Initializable {

    @FXML
    private ComboBox<String> firstAlgo;

    @FXML
    private ComboBox<String> secondAlgo;

    @FXML
    private LineChart<String, Double> algo1;

    @FXML
    private LineChart<String, Double> algo2;

    @FXML
    private Button backBtn;

    @FXML
    private Button compareBtn;

    ObservableList<String> list1 = FXCollections.observableArrayList( "Insertion Sort","Merge Sort","Heap Sort","Bubble Sort", "Quick Sort", "Selection Sort" , "Counting Sort", "Radix Sort");
    ObservableList<String> list2 = FXCollections.observableArrayList( "Insertion Sort","Merge Sort","Heap Sort","Bubble Sort", "Quick Sort", "Selection Sort" , "Counting Sort", "Radix Sort");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstAlgo.setItems(list1);
        secondAlgo.setItems(list2);
    }


    @FXML
    void compare(MouseEvent event) throws FileNotFoundException {
        algo1.getData().clear();
        if (firstAlgo.getValue() == "Insertion Sort" || secondAlgo.getValue() == "Insertion Sort") {

            XYChart.Series<String, Double> insertion = new XYChart.Series<String, Double>();
            Insertion ab = new Insertion();
            ab.createFile();

            for (int i = 10; i <= 1000; i += 10)
                insertion.getData().add(new XYChart.Data<>(String.valueOf(i), ab.sort(i)));
            insertion.setName("Insertion Algo Sorting Time");
            algo1.getData().addAll(insertion);
        }
        if (firstAlgo.getValue() == "Heap Sort" || secondAlgo.getValue() == "Heap Sort") {
            XYChart.Series<String, Double> heap = new XYChart.Series<String, Double>();
            Heap h = new Heap();
            h.createFile();

            for (int i=10; i<=1000; i+=10)
                heap.getData().add(new XYChart.Data<>(String.valueOf(i), h.sort(i)));
            heap.setName("Heap Algo Sorting Time");
            algo1.getData().addAll(heap);
        }
        if (firstAlgo.getValue() == "Counting Sort" || secondAlgo.getValue() == "Counting Sort"){
            XYChart.Series<String, Double> counting = new XYChart.Series<String, Double>();
            Counting z = new Counting();
            z.createFile();

            for (int i=10; i<=1000; i+=10)
                counting.getData().add(new XYChart.Data<>(String.valueOf(i), z.sort(i)));
            counting.setName("Counting Algo Sorting Time");

            algo1.getData().addAll(counting);
        }
        if (firstAlgo.getValue() == "Bubble Sort" || secondAlgo.getValue() == "Bubble Sort"){

            XYChart.Series<String, Double> bubble = new XYChart.Series<String, Double>();
            Bubble b = new Bubble();
            b.createFile();

            for (int i=10; i<=1000; i+=10)
                bubble.getData().add(new XYChart.Data<>(String.valueOf(i), b.sort(i)));
            bubble.setName("Bubble Algo Sorting Time");


            algo1.getData().addAll(bubble);
        }
        if (firstAlgo.getValue() == "Quick Sort" || secondAlgo.getValue() == "Quick Sort"){

            XYChart.Series<String, Double> quick = new XYChart.Series<String, Double>();
            Quick q = new Quick();
            q.createFile();

            for (int i=10; i<=1000; i+=10)
                quick.getData().add(new XYChart.Data<>(String.valueOf(i), q.sort(i)));
            quick.setName("Quick Algo Sorting Time");


            algo1.getData().addAll(quick);
        }
        if (firstAlgo.getValue() == "Selection Sort" || secondAlgo.getValue() == "Selection Sort" ){

            XYChart.Series<String, Double> selection = new XYChart.Series<String, Double>();
            Selection s = new Selection();
            s.createFile();

            for (int i=10; i<=1000; i+=10)
                selection.getData().add(new XYChart.Data<>(String.valueOf(i), s.sort(i)));
            selection.setName("Selection Algo Sorting Time");

            algo1.getData().addAll(selection);
        }
        if (firstAlgo.getValue() == "Merge Sort" || secondAlgo.getValue() == "Merge Sort"){

            XYChart.Series<String, Double> merge = new XYChart.Series<String, Double>();
            Merge m = new Merge();
            m.createFile();

            for (int i=10; i<=1000; i+=10)
                merge.getData().add(new XYChart.Data<>(String.valueOf(i), m.sort(i)));
            merge.setName("Merge Algo Sorting Time");

            algo1.getData().addAll(merge);
        }
        if (firstAlgo.getValue() == "Radix Sort" || secondAlgo.getValue() == "Radix Sort"){

            XYChart.Series<String, Double> insertion = new XYChart.Series<String, Double>();
            Radix r = new Radix();
            r.createFile();

            for (int i=10; i<=1000; i+=10)
                insertion.getData().add(new XYChart.Data<>(String.valueOf(i), r.sort(i)));
            insertion.setName("Radix Algo Sorting Time");

            algo1.getData().addAll(insertion);
        }
    }



    @FXML
    void backToMain(MouseEvent event) throws IOException {
        Stage singleStage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        singleStage.setTitle("Khawarizmi");
        singleStage .setScene(new Scene(root));
    }

}
