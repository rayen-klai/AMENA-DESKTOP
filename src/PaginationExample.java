
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaginationExample extends Application {

    private static final int PAGE_SIZE = 10;
    private static final int NUM_ITEMS = 100;

    @Override
    public void start(Stage stage) {

        Pagination pagination = new Pagination(NUM_ITEMS / PAGE_SIZE, 0);
        pagination.setPageFactory(pageIndex -> createPage(pageIndex));

        VBox root = new VBox(10);
        root.getChildren().add(pagination);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private Node createPage(int pageIndex) {
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}