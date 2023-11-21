package view;

import controller.TopViewcontroller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import model.SyuukanModel;

public class TargetView extends BaseView {


	/*private int count2;

	@FXML private Pane root;
	@FXML private ProgressIndicator progressIndicator;
	@FXML private Circle circle;*/


	public TargetView() {
		super("Target.fxml");

	}

	@Override
	public void Init() {



		//model
		SyuukanModel m = (SyuukanModel) getModel();

		Label testLabel = (Label) getPane().lookup("#testLabel");

		testLabel.setText(TopViewcontroller.targetString);

		Label enthusiasm_label = (Label) getPane().lookup("#enthusiasm_label");
		enthusiasm_label.setText(TopViewcontroller.enthusiasmString);



		//カウントアップ

		Button Btn_count = (Button) getPane().lookup("#Btn_count");
		Arc arc =(Arc) getPane().lookup("#arc");

		m_pane.getChildren().addAll(
				arc,Btn_count
				);




		/*Button Btn_count = (Button) getPane().lookup("#Btn_count");
		Label counter = (Label) getPane().lookup("#counter");

		Btn_count.setOnAction( new EventHandler<ActionEvent>() {

			public void handle(ActionEvent args0) {

				counter.setText(String.valueOf(count++));

				if (count == 31) {
					count = 1;

					num++;

				}

			}
		});*/

	}
}