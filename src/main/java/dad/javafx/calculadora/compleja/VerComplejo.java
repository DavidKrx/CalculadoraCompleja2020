package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VerComplejo extends Application {
	Complejo complejo1 = new Complejo();
	Complejo complejo2 = new Complejo();
	Complejo complejoResul = new Complejo();
	private TextField realTxt1;
	private TextField imagineTxt1;
	private TextField realTxt2;
	private TextField imagineTxt2;
	private TextField resultRealTxt;
	private TextField resultImagineTxt;
	private ComboBox<String> operaciones;

	public void start(Stage stage) {

		realTxt1 = new TextField();// =Complejo1.getReal

		imagineTxt1 = new TextField();// =Complejo1.getImagine

		HBox Complejo1HB = new HBox();
		Complejo1HB.setAlignment(Pos.CENTER);
		Complejo1HB.setSpacing(5);
		Complejo1HB.getChildren().addAll(realTxt1, new Label("+"), imagineTxt1, new Label("i"));

		realTxt2 = new TextField();// =Complejo2.getReal

		imagineTxt2 = new TextField();// =Complejo2.getImagine

		HBox Complejo2HB = new HBox();
		Complejo2HB.setAlignment(Pos.CENTER);
		Complejo2HB.setSpacing(5);
		Complejo2HB.getChildren().addAll(realTxt2, new Label("+"), imagineTxt2, new Label("i"));

		operaciones = new ComboBox<>();
		operaciones.getItems().addAll("+", "-", "*", "/");
		operaciones.getSelectionModel().select("+");

		resultRealTxt = new TextField();

		resultImagineTxt = new TextField();

		HBox ResultComplejo = new HBox();
		ResultComplejo.setAlignment(Pos.CENTER);
		ResultComplejo.setSpacing(5);
		ResultComplejo.getChildren().addAll(resultRealTxt, new Label("+"), resultImagineTxt, new Label("i"));
		ResultComplejo.setDisable(true);
		;

		VBox center = new VBox();
		center.setSpacing(5);
		center.setAlignment(Pos.CENTER);
		center.getChildren().addAll(Complejo1HB, Complejo2HB, ResultComplejo);

		VBox izqcombo = new VBox();
		izqcombo.setSpacing(5);
		izqcombo.setAlignment(Pos.CENTER_LEFT);
		izqcombo.getChildren().add(operaciones);

		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(izqcombo, center);

		Scene scene = new Scene(root, 320, 200);
		stage.setTitle("Complejo");
		stage.setScene(scene);
		stage.show();

		StratBinding();
	}

	private void StratBinding() {
		realTxt1.textProperty().bindBidirectional(complejo1.realProperty(), new NumberStringConverter());
		imagineTxt1.textProperty().bindBidirectional(complejo1.imaginarioProperty(), new NumberStringConverter());

		realTxt2.textProperty().bindBidirectional(complejo2.realProperty(), new NumberStringConverter());
		imagineTxt2.textProperty().bindBidirectional(complejo2.imaginarioProperty(), new NumberStringConverter());

		resultRealTxt.textProperty().bindBidirectional(complejoResul.realProperty(), new NumberStringConverter());
		resultImagineTxt.textProperty().bindBidirectional(complejoResul.imaginarioProperty(),
				new NumberStringConverter());

		realTxt1.textProperty().addListener((obj, o, n) -> {
			this.calcula();
		});
		imagineTxt1.textProperty().addListener((obj, o, n) -> {
			this.calcula();
		});

		realTxt2.textProperty().addListener((obj, o, n) -> {
			this.calcula();
		});
		imagineTxt2.textProperty().addListener((obj, o, n) -> {
			this.calcula();
		});

		operaciones.valueProperty().addListener((obj, o, n) -> {
			this.calcula();
		});

	}

	public void calcula() {

		switch (operaciones.getSelectionModel().getSelectedItem()) {

		case "+":
			complejoResul.realProperty().bind(complejo1.add(complejo2));
			complejoResul.imaginarioProperty().bind(complejo1.addimg(complejo2));
			break;

		case "-":
			complejoResul.realProperty().bind(complejo1.sub(complejo2));
			complejoResul.imaginarioProperty().bind(complejo1.subimg(complejo2));
			break;

		case "*":
			complejoResul.realProperty().bind(complejo1.multi(complejo2));
			complejoResul.imaginarioProperty().bind(complejo1.multiimg(complejo2));
			break;

		case "/":
			complejoResul.realProperty().bind(complejo1.divi(complejo2));
			complejoResul.imaginarioProperty().bind(complejo1.diviimg(complejo2));
			break;

		default:
			break;

		}
	}

	public static void main(String args[]) {
		launch(args);
	}
}
