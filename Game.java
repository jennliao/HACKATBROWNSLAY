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
    private int imageCount;

    public Game(Pane gamePane, ImageView background){
        this.gamePane = gamePane;
        this.background = background;
        this.imageCount = 0;

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

        this.morriss = new NPCharacter(this.gamePane, "./HACKATBROWNSLAY/transparent-morriss.png",
                Constants.START_LOCS[2]);

        this.provi = new NPCharacter(this.gamePane, "./HACKATBROWNSLAY/transparent-provi.png",
                Constants.START_LOCS[3]);
    }

    private void createLocs(){
        this.dock = new Rectangle(Constants.DOCK_SIZE[0], Constants.DOCK_SIZE[1]);
        this.dock.setX(Constants.DOCK_LOC[0]);
        this.dock.setY(Constants.DOCK_LOC[1]);

        this.forest = new Rectangle(Constants.FOREST_SIZE[0], Constants.FOREST_SIZE[1]);
        this.forest.setX(Constants.FOREST_LOC[0]);
        this.forest.setY(Constants.FOREST_LOC[1]);

        this.backpack = new Circle(Constants.BACKPACK_LOC[0], Constants.BACKPACK_LOC[1], Constants.BACKPACK_RADIUS);

        this.mudHole = new Rectangle(Constants.MUDHOLE_SIZE[0], Constants.MUDHOLE_SIZE[1]);
        this.mudHole.setX(Constants.MUDHOLE_LOC[0]);
        this.mudHole.setY(Constants.MUDHOLE_LOC[1]);

        this.campfire = new Rectangle(Constants.CAMPFIRE_SIZE[0], Constants.CAMPFIRE_SIZE[1]);
        this.campfire.setX(Constants.CAMPFIRE_LOC[0]);
        this.campfire.setY(Constants.CAMPFIRE_LOC[1]);

        this.gamePane.getChildren().addAll(this.campfire);
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

    private void updateTimeline(){
        if (this.imageCount < 2 && this.mainC.intersects(this.backpack)){
            this.changeImage();
        }
        if(this.imageCount > 1 && this.imageCount < 5 && this.mainC.intersects(this.dock)){
            this.changeImage();
        }
        if(this.imageCount > 4 && this.imageCount < 9 && this.mainC.intersects(this.mudHole)){
            this.changeImage();
        }
        if(this.imageCount > 8 && this.imageCount < 11 && this.mainC.intersects(this.forest)){
            this.changeImage();
        }
    }

    private void changeImage(){
        switch (this.imageCount) {
            case 0:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map1.jpg"));
                break;
            case 1:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map-with-tent.jpg"));
                break;
            case 2:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map3.jpg"));
                break;
            case 3:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map4.jpg"));
                break;
            case 4:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map5.jpg"));
                break;
            case 5:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map6.jpg"));
                break;
            case 6:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map7.jpg"));
                break;
            case 8:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map8.jpg"));
                break;
            case 9:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map9.jpg"));
                break;
            case 10:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map10.jpg"));
                break;
            case 11:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map11.jpg"));
                break;
            case 12:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map12.jpg"));
                break;
            case 13:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map13.jpg"));
                break;
            case 14:
                this.background.setImage(new Image("./HACKATBROWNSLAY/map14.jpg"));
                break;
        }
        this.imageCount++;
    }


    private void backpackTimeline(){
        KeyFrame kf = new KeyFrame(
                Duration.seconds(1),
                (ActionEvent e) -> this.updateTimeline());
        Timeline timeline = new Timeline(kf);

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
