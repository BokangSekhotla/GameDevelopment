module com.example.bokangsekhotlagame {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.bokangsekhotlagame to javafx.fxml;
    exports com.example.bokangsekhotlagame;
}