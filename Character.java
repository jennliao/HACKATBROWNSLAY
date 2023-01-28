package HACKATBROWNSLAY;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Character {
    private Pane gamePane;
    private ImageView character;
    public Character(Pane gamePane, String imageURL, int[] startLoc){
        this.gamePane = gamePane;
        this.setUpImage(imageURL, startLoc);
    }

    private void setUpImage(String imageURL, int[]startLoc){
        Image mcImage = new Image(imageURL);
        this.character = new ImageView();
        this.character.setImage(mcImage);
        this.character.setX(startLoc[0]);
        this.character.setY(startLoc[1]);
        this.character.setFitWidth(200);
        this.character.setPreserveRatio(true);

        this.gamePane.getChildren().add(this.character);

    }

    public void moveRight(){
        this.character.setX(this.character.getX() + 10);
    }

    public void moveLeft(){
        this.character.setX(this.character.getX() - 10);
    }

    public void moveUp(){
        this.character.setY(this.character.getY() - 10);
    }

    public void moveDown(){
        this.character.setY(this.character.getY() + 10);
    }
}
