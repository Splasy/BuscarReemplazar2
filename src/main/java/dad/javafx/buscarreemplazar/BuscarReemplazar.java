package dad.javafx.buscarreemplazar;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarReemplazar extends Application {
	
	private TextField buscarText;
	private TextField reemplazarText;
	private Button buscarButton;
	private Button reemplazarButton;
	private Button reemplazarTodoButton;
	private Button cerrarButton;
	private Button ayudaButton;
	private RadioButton mayusRadio;
	private RadioButton buscarAtrasRadio;
	private RadioButton expresionRegularRadio;
	private RadioButton resaltarRadio;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		buscarText = new TextField();
		reemplazarText = new TextField();
		
		buscarButton = new Button("Buscar");
		buscarButton.setPrefWidth(150);
		reemplazarButton = new Button("Reemplazar");
		reemplazarButton.setPrefWidth(150);
		reemplazarTodoButton = new Button("Reemplazar todo");
		reemplazarTodoButton.setPrefWidth(150);
		cerrarButton = new Button("Cerrar");
		cerrarButton.setPrefWidth(150);
		ayudaButton = new Button("Ayudar");
		ayudaButton.setPrefWidth(150);
	
		
		mayusRadio = new RadioButton("Mayúsculas y minúsculas");
		mayusRadio.setPrefWidth(150);
		buscarAtrasRadio = new RadioButton("Buscar hacia atrás");
		buscarAtrasRadio.setPrefWidth(150);
		expresionRegularRadio = new RadioButton("Expresión regular");
		expresionRegularRadio.setPrefWidth(150);
		resaltarRadio = new RadioButton("Resaltar resultados");
		resaltarRadio.setPrefWidth(150);
		
		ToggleGroup grupoToggle = new ToggleGroup();
		grupoToggle.getToggles().addAll(mayusRadio, buscarAtrasRadio, expresionRegularRadio, resaltarRadio);
		
		VBox botonera = new VBox();
		botonera.setSpacing(5);
		botonera.setPadding(new Insets(0, 5, 5, 0));
		botonera.getChildren().addAll(reemplazarTodoButton, cerrarButton, ayudaButton);
		
		/*HBox radio1 = new HBox();
		radio1.getChildren().addAll(mayusRadio, buscarAtrasRadio);
		
		HBox radio2 = new HBox();
		radio2.getChildren().addAll(expresionRegularRadio, resaltarRadio);*/
		GridPane grid = new GridPane();
		grid.addRow(0, mayusRadio, buscarAtrasRadio);
		grid.addRow(1, expresionRegularRadio, resaltarRadio);
		grid.setVgap(5);
		
		//Restricciones del GridPane de arriba
		
		ColumnConstraints [] constraints1 = {new ColumnConstraints(), new ColumnConstraints()};
		constraints1[0].setHalignment(HPos.LEFT);
		constraints1[1].setHalignment(HPos.LEFT);
		constraints1[0].setHgrow(Priority.ALWAYS);
		constraints1[1].setHgrow(Priority.ALWAYS);
		
		grid.getColumnConstraints().setAll(constraints1);
		
		GridPane root = new GridPane();
		root.setGridLinesVisible(false);
		root.setHgap(5);
		root.setVgap(5);
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(5));
		root.addRow(0, new Label("Buscar: "), buscarText, buscarButton);
		root.addRow(1, new Label("Reemplazar con: "), reemplazarText, reemplazarButton);
		root.addRow(2, new Label(""), grid, botonera);
		
		
		ColumnConstraints [] constraintsRoot = {new ColumnConstraints(), new ColumnConstraints()};
		
		constraintsRoot[0].setHalignment(HPos.LEFT);
		constraintsRoot[1].setFillWidth(true);
		constraintsRoot[1].setHgrow(Priority.ALWAYS);
		//constraintsRoot[2].setHalignment(HPos.RIGHT); Preguntar cómo echar todos los radioButton a la derecha
		
		root.getColumnConstraints().setAll(constraintsRoot);
		
		Scene scene = new Scene(root, 480, 320);
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
