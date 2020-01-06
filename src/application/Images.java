package application;

import javafx.scene.image.WritableImage;

public class Images {
	double redLevel;
	WritableImage image;

	public Images(WritableImage i, double x) {

		image = i;
		redLevel = x;

	}

	public WritableImage getImage() {
		return image;
	}

	public void setRedLevel(double rl) {
		redLevel = rl;
	}

	public double getRedLevel() {
		return redLevel;
	}

}
