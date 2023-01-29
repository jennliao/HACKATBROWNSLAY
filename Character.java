package HACKATBROWNSLAY;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
        this.character.setFitWidth(50);
        this.character.setPreserveRatio(true);

        this.gamePane.getChildren().add(this.character);
    }

    public void setSize(int fitWidth){
        this.character.setFitWidth(fitWidth);
    }

    private Rectangle getBounds(){
        return new Rectangle(this.character.getX(), this.character.getY(), this.character.getFitWidth(),
                this.character.getFitHeight());
    }

    public boolean intersects(Shape region) {
        return region.getBoundsInParent().intersects(this.getBounds().getBoundsInParent());
    }

    public void moveRight(){
        this.character.setX(this.character.getX() + 15);
    }

    public void moveLeft(){
        this.character.setX(this.character.getX() - 15);
    }

    public void moveUp(){
        this.character.setY(this.character.getY() - 15);
    }

    public void moveDown(){
        this.character.setY(this.character.getY() + 15);
    }
}
