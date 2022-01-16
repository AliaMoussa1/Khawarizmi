import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainControl {

    @FXML
    private ImageView image;
    @FXML
    private Button singleBtn;
    @FXML
    private Button comparisonBtn;


    @FXML
    void singleSortScene(MouseEvent event) throws IOException {
        Stage singleStage = (Stage) singleBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("singleSort.fxml"));
        singleStage.setTitle("Compare Sorting Algorithm to its Asymptotic Efficiency");
        singleStage .setScene(new Scene(root));
    }


    @FXML
    void comparisonScene(MouseEvent event) throws IOException {
        Stage comparisonStage = (Stage) comparisonBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("comparison.fxml"));
        comparisonStage.setTitle("Compare Sorting Algorithms to each other");
        comparisonStage .setScene(new Scene(root));
    }



}
