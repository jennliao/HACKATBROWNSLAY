package HACKATBROWNSLAY;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
    private BorderPane root;
    private Pane gamePane;
    private Pane backgroundPane;
    private Game game;

    public PaneOrganizer(){
        this.root = new BorderPane();

        this.createBackgroundPane();
        this.createGamePane();

        this.game = new Game(this.gamePane);
    }

    public BorderPane getRoot(){
        return this.root;
    }

    private void createBackgroundPane(){
        this.backgroundPane = new Pane();
        this.backgroundPane.setPrefSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        this.root.setCenter(this.backgroundPane);
    }

    private void createGamePane(){
        this.gamePane = new Pane();
        this.gamePane.setPrefSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        this.root.setCenter(this.gamePane);

        this.gamePane.setOnKeyPressed((KeyEvent event) -> this.game.handleKeyPressed(event));
        this.gamePane.setFocusTraversable(true);
    }

}
