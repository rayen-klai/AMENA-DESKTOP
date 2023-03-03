import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CountdownDays extends Application {

    private static final LocalDate END_DATE = LocalDate.of(2023, 3, 3);
    private Label countdownLabel = new Label();
    private Timeline timeline;

  //  public CountdownDays(String )
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane(countdownLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateCountdown()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private String updateCountdown() {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), END_DATE);
        return (String.format("Countdown: %d days", days));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        timeline.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
