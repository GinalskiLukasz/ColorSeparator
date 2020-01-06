package application;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends HBox

{

	public Square() {

		Rectangle square1 = new Rectangle(0, 0, 41, 41);
		square1.setFill(null);
		square1.setStroke(Color.BLUE);

		Rectangle square2 = new Rectangle(0, 0, 41, 41);
		square2.setFill(null);
		square2.setStroke(Color.BLUE);
		Rectangle square3 = new Rectangle(0, 0, 41, 41);
		square3.setFill(null);
		square3.setStroke(Color.BLUE);
		Rectangle square4 = new Rectangle(0, 0, 41, 41);
		square4.setFill(null);
		square4.setStroke(Color.BLUE);
		Rectangle square5 = new Rectangle(0, 0, 41, 41);
		square5.setFill(null);
		square5.setStroke(Color.BLUE);

		HBox kwadraty = new HBox(15, square1, square2, square3, square4, square5);
		this.getChildren().addAll(kwadraty);
	}

}