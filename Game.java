package HACKATBROWNSLAY;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Game {
    private Character mainC;
    private Pane gamePane;
    private ImageView background;
    private NPCharacter smitty;
    private NPCharacter morriss;
    private NPCharacter provi;

    private Rectangle dock;
    private Rectangle forest;
    private Rectangle mudHole;
    private Circle backpack;
    private Rectangle campfire;

    private boolean fished;
    private boolean builtTent;
    private boolean collectedWood;
    private boolean mudFought;

    public Game(Pane gamePane, ImageView background){
        this.gamePane = gamePane;
        this.background = background;

        this.setTasks();
        this.createLocs();
        this.mainC = new Character(this.gamePane, "HACKATBROWNSLAY/main-character.png",
                Constants.START_LOCS[0]);
        this.createNPCs();
        this.backpackTimeline();
    }

    private void setTasks(){
        this.fished = false;
        this.builtTent = false;
        this.collectedWood = false;
        this.mudFought = false;
    }

    private void createNPCs(){
        this.smitty = new NPCharacter(this.gamePane, "./HACKATBROWNSLAY/smitty.png",
                Constants.START_LOCS[1]);
        this.smitty.setSize(Constants.SMITTY_SIZE);

    }

    private void createLocs(){
        this.dock = new Rectangle(Constants.DOCK_SIZE[0], Constants.DOCK_SIZE[1]);
        this.dock.setX(Constants.DOCK_LOC[0]);
        this.dock.setY(Constants.DOCK_LOC[1]);

        this.forest = new Rectangle(Constants.FOREST_SIZE[0], Constants.FOREST_SIZE[1]);
        this.forest.setX(Constants.FOREST_LOC[0]);
        this.forest.setY(Constants.FOREST_LOC[1]);

        this.backpack = new Circle(Constants.BACKPACK_LOC[0], Constants.BACKPACK_LOC[1], Constants.BACKPACK_RADIUS);

        this.gamePane.getChildren().addAll(this.dock, this.forest);
    }



    public void handleKeyPressed(KeyEvent event) {

            KeyCode keyPressed = event.getCode();
            switch (keyPressed) {
                case LEFT:
                    this.mainC.moveLeft();
                    break;
                case RIGHT:
                    this.mainC.moveRight();
                    break;
                case UP:
                    this.mainC.moveUp();
                    break;
                case DOWN:
                    this.mainC.moveDown();
                default:
                    break;
            }

    }

    private void updateBackPackTimeline(){
        if (this.mainC.intersects(this.backpack)){

            this.background.setImage(new Image("./HACKATBROWNSLAY/map1.jpg"));
            System.out.println("test");
            this.background.setImage(new Image("./HACKATBROWNSLAY/map-with-tent.jpg"));
        }
    }

    private int changeImage(int imageCount){
        switch (imageCount) {
            case 0:
                this.background.setImage(this.background.setImage(new Image("./HACKATBROWNSLAY/map-with-tent.jpg"));


        }
    }


    private void backpackTimeline(){
        KeyFrame kf = new KeyFrame(
                Duration.seconds(1),
                (ActionEvent e) -> this.updateBackPackTimeline());
        Timeline timeline = new Timeline(kf);

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
