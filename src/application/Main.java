package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

	public void start(Stage primaryStage) {

		try {

			Group root = new Group();
			Scene scene = new Scene(root, 650, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("SEGREGATOR KOLORÓW");

			Canvas canvas = new Canvas(650, 400); // deklarujê i budujê obiekt typu Canvas
			GraphicsContext gc = canvas.getGraphicsContext2D();
			Image image = new Image(getClass().getResourceAsStream("galaxy.png"));

			gc.fillRect(12, 12, 288, 363);
			gc.drawImage(image, 15, 15, 282, 357);

			Button clear = new Button("Czyœæ");
			clear.setPrefSize(120, 25);
			clear.setLayoutX(500);
			clear.setLayoutY(20);

			Label info = new Label("Wycinki w kolejnoœci malej¹cej wartoœci sk³adowej ");
			info.setPrefSize(320, 20);
			info.setLayoutX(320);
			info.setLayoutY(55);
			Label info2 = new Label(" czerwonej");
			info2.setPrefSize(320, 20);
			info2.setLayoutX(320);
			info2.setLayoutY(75);

			Squares squares = new Squares();
			squares.setLayoutX(320);
			squares.setLayoutY(100);

			root.getChildren().addAll(canvas, clear, info, info2, squares);

			ArrayList<Images> images = new ArrayList<Images>();
			WritableImage dstImage2 = new WritableImage(41, 41); // Wype³niam listê bia³ymi kwadratami
			PixelWriter writer = dstImage2.getPixelWriter();

			for (int x = 0; x < 41; x++)
				for (int y = 0; y < 41; y++) {
					writer.setColor(x, y, Color.WHITE);

				}

			for (int i = 0; i < 50; i++) {
				Images picture = new Images(dstImage2, 0);
				images.add(picture);
			}

			Sorting sorting = new Sorting(); // deklarujê i budujê obiekt typu Sorting

			canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
				int a = (int) event.getX(); //
				int b = (int) event.getY();

				if (a < 17 || a > 292 || b < 17 || b > 368)

				{
					Alert alert = new Alert(AlertType.INFORMATION, "Klikn¹³eœ/aœ poza obszar zdjêcia");
					alert.show();
					System.out.println("klinales za");
				} else {
					int pixelCounter = 0; // licznik, przez tyle bede dzieli³ wartoœæ SUMY SKLADOWEJ koloru RED
					double redTotal = 0;
					double redAverage = 0;

					System.out.println("x:" + event.getX() + "y:" + event.getSceneY());

					PixelReader reader = image.getPixelReader(); // wczytuje pixele
					WritableImage dstImage = new WritableImage(41, 41); // buduje obiekt na ktorym mozna rysowac pixele
					PixelWriter writer2 = dstImage.getPixelWriter(); // rysuje pixele

					for (int x = 0; x < 41; x++) // robimy pêntlê ktora bedzie nam przeczesywala kazdy pixel
						for (int y = 0; y < 41; y++) {

							Color color = reader.getColor(a + x - 39, b + y - 39);
							pixelCounter++;
							redTotal = redTotal + color.getRed();

							writer2.setColor(x, y, Color.color(color.getRed(), color.getGreen(), color.getBlue()

							));

						}
					redAverage = redTotal / pixelCounter;
					Images picture = new Images(dstImage, redAverage); // BUDUJE OBRAZ

					images.add(picture); // DODAJE OBRAZ DO LISTY
					images.sort(sorting); // SORTUJE LISTE

					gc.drawImage(images.get(0).getImage(), 320, 100, 41, 41);
					gc.drawImage(images.get(1).getImage(), 377, 100, 41, 41);
					gc.drawImage(images.get(2).getImage(), 434, 100, 41, 41);
					gc.drawImage(images.get(3).getImage(), 491, 100, 41, 41);
					gc.drawImage(images.get(4).getImage(), 548, 100, 41, 41);

					gc.drawImage(images.get(5).getImage(), 320, 157, 41, 41);
					gc.drawImage(images.get(6).getImage(), 377, 157, 41, 41);
					gc.drawImage(images.get(7).getImage(), 434, 157, 41, 41);
					gc.drawImage(images.get(8).getImage(), 491, 157, 41, 41);
					gc.drawImage(images.get(9).getImage(), 548, 157, 41, 41);

					gc.drawImage(images.get(10).getImage(), 320, 214, 41, 41);
					gc.drawImage(images.get(11).getImage(), 377, 214, 41, 41);
					gc.drawImage(images.get(12).getImage(), 434, 214, 41, 41);
					gc.drawImage(images.get(13).getImage(), 491, 214, 41, 41);
					gc.drawImage(images.get(14).getImage(), 548, 214, 41, 41);

					gc.drawImage(images.get(15).getImage(), 320, 271, 41, 41);
					gc.drawImage(images.get(16).getImage(), 377, 271, 41, 41);
					gc.drawImage(images.get(17).getImage(), 434, 271, 41, 41);
					gc.drawImage(images.get(18).getImage(), 491, 271, 41, 41);
					gc.drawImage(images.get(19).getImage(), 548, 271, 41, 41);

					gc.drawImage(images.get(20).getImage(), 320, 328, 41, 41);
					gc.drawImage(images.get(21).getImage(), 377, 328, 41, 41);
					gc.drawImage(images.get(22).getImage(), 434, 328, 41, 41);
					gc.drawImage(images.get(23).getImage(), 491, 328, 41, 41);
					gc.drawImage(images.get(24).getImage(), 548, 328, 41, 41);

				}
			}

			);

			clear.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					images.clear();

					WritableImage dstImage2 = new WritableImage(41, 41);
					PixelWriter writer = dstImage2.getPixelWriter();

					for (int x = 0; x < 41; x++)
						for (int y = 0; y < 41; y++) {
							writer.setColor(x, y, Color.WHITE);

						}

					for (int i = 0; i < 50; i++) {
						Images picture = new Images(dstImage2, 0);
						images.add(picture);
					}

					gc.drawImage(dstImage2, 320, 100, 41, 41);
					gc.drawImage(dstImage2, 377, 100, 41, 41);
					gc.drawImage(dstImage2, 434, 100, 41, 41);
					gc.drawImage(dstImage2, 491, 100, 41, 41);
					gc.drawImage(dstImage2, 548, 100, 41, 41);

					gc.drawImage(dstImage2, 320, 157, 41, 41);
					gc.drawImage(dstImage2, 377, 157, 41, 41);
					gc.drawImage(dstImage2, 434, 157, 41, 41);
					gc.drawImage(dstImage2, 491, 157, 41, 41);
					gc.drawImage(dstImage2, 548, 157, 41, 41);

					gc.drawImage(dstImage2, 320, 214, 41, 41);
					gc.drawImage(dstImage2, 377, 214, 41, 41);
					gc.drawImage(dstImage2, 434, 214, 41, 41);
					gc.drawImage(dstImage2, 491, 214, 41, 41);
					gc.drawImage(dstImage2, 548, 214, 41, 41);

					gc.drawImage(dstImage2, 320, 271, 41, 41);
					gc.drawImage(dstImage2, 377, 271, 41, 41);
					gc.drawImage(dstImage2, 434, 271, 41, 41);
					gc.drawImage(dstImage2, 491, 271, 41, 41);
					gc.drawImage(dstImage2, 548, 271, 41, 41);

					gc.drawImage(dstImage2, 320, 328, 41, 41);
					gc.drawImage(dstImage2, 377, 328, 41, 41);
					gc.drawImage(dstImage2, 434, 328, 41, 41);
					gc.drawImage(dstImage2, 491, 328, 41, 41);
					gc.drawImage(dstImage2, 548, 328, 41, 41);

				}

			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
