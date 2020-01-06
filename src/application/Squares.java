package application;

import javafx.scene.layout.VBox;

public class Squares extends VBox {
	public Squares() {

		Square column1 = new Square();
		Square column2 = new Square();
		Square column3 = new Square();
		Square column4 = new Square();
		Square column5 = new Square();

		VBox columns = new VBox(15, column1, column2, column3, column4, column5);
		this.getChildren().addAll(columns);

	}

}
