package HACKATBROWNSLAY;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage)  {
        stage.setTitle("CAMP HAK");
        PaneOrganizer organizer = new PaneOrganizer();

        Scene scene = new Scene(organizer.getRoot(), Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }

    /*
     * Here is the mainline! No need to change this.
     */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
