package HACKATBROWNSLAY;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Game {
    private Character mainC;
    private Pane gamePane;
    private NPCharacter smitty;
    private NPCharacter morriss;
    private NPCharacter provi;
    private boolean fished;
    private boolean builtTent;
    private boolean collectedWood;
    private boolean mudFought;

    public Game(Pane gamePane){
        this.gamePane = gamePane;
        this.setTasks();
        this.mainC = new Character(this.gamePane, "./HACKATBROWNSLAY/stick-figure.jpeg",
                Constants.START_LOCS[0]);
        this.createNPCs();
    }

    private void setTasks(){
        this.fished = false;
        this.builtTent = false;
        this.collectedWood = false;
        this.mudFought = false;
    }

    private void createNPCs(){
        this.smitty = new NPCharacter(this.gamePane, "./HACKATBROWNSLAY/npc-placeholder.jpeg",
                Constants.START_LOCS[1]);

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
}
