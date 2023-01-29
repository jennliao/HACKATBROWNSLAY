package HACKATBROWNSLAY;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
    private BorderPane root;
    private Pane gamePane;
    private Pane backgroundPane;
    private ImageView background;
    private Game game;

    public PaneOrganizer(){
        this.root = new BorderPane();

        this.createGamePane();
//        this.createBackgroundPane();

        this.game = new Game(this.gamePane, this.background);
    }

    public BorderPane getRoot(){
        return this.root;
    }


    private void createGamePane(){
        this.gamePane = new Pane();
        this.gamePane.setPrefSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        this.root.setCenter(this.gamePane);

        Image backgroundImage = new Image("./HACKATBROWNSLAY/base-map.jpeg");
        this.background = new ImageView();
        background.setImage(backgroundImage);

        background.setFitHeight(750);
        background.setPreserveRatio(true);


        this.gamePane.getChildren().add(background);

        this.gamePane.setOnKeyPressed((KeyEvent event) -> this.game.handleKeyPressed(event));
        this.gamePane.setFocusTraversable(true);
    }

}
