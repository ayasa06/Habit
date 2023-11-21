package controller;

import java.util.ArrayList;
import java.util.HashMap;

import dbmanager.AccessManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import model.SyuukanModel;
import view.BaseView;
import view.ColumnView;
import view.HistoryView;
import view.TargetView;
import view.TitleView;

public class TopViewcontroller {

	@FXML
	public TextField target;

	@FXML
	public TextField enthusiasm;

	@FXML
	public Label testLabel;
	@FXML
	public Label enthusiasm_label;

	@FXML
	public Label counter;

	@FXML
	public static String targetString;
	@FXML
	public static String enthusiasmString;

	@FXML private Pane root;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private Circle circle;


	static int num = 0;
    public static int count = 1;
    public static int count_2 =1;



	@FXML
	void Btn_Column(ActionEvent e) {

		ColumnView view = new ColumnView();
		view.ShowView(null);


	}
	@FXML
	void Btn_h(ActionEvent e) {

		HistoryView view = new HistoryView();
		view.ShowView(null);

	}


	@FXML //OKボタンクリック
	void onBtnContinue(ActionEvent e) {

		// モデルの生成
		SyuukanModel m = new SyuukanModel();
		m.setTarget(targetString = target.getText());

		SyuukanModel m2 = (SyuukanModel) BaseView.getModel();
		m.setEnthusiasm(enthusiasmString = enthusiasm.getText());

		//DBにINSERTをする処理

		AccessManager db = new AccessManager("db.accdb");


		SyuukanModel utm = new SyuukanModel();

		utm.setTarget(TopViewcontroller.targetString);
		utm.setEnthusiasm(TopViewcontroller.enthusiasmString);

		//INSERT文の発行
		StringBuilder sql = new StringBuilder("INSERT INTO HistoryTable(");

		//DBのINSERTする項目名
		sql.append("aim,enthusiasm");

		//DBへINSERTする値
		sql.append(")VALUES(");

		sql.append("'" + utm.getTarget() + "'");
		sql.append(",");
		sql.append("'" + utm.getEnthusiasm() + "'");
		sql.append(");");

		db.insert(sql.toString());
		System.out.println("aaaaa");

		//送信画面を表示する
		TargetView view = new TargetView();
		view.ShowView(m);

		targetString = target.getText();
		enthusiasmString = enthusiasm.getText();

	}

	@FXML
	void Btn_return(ActionEvent e) {

		AccessManager db = new AccessManager("db.accdb");

		String Sql = "SELECT * FROM HistoryTable";

		String[] columns = { "ID","aim", "enthusiasm","kaisuu" };


		ArrayList<HashMap<String, String>> result = db.select(Sql, columns);

		if(result.size() <= 0) {
			return;
		}

		int maxid = 0;
		System.out.println(result.get( result.size() - 1 ).get("kaisuu"));

		maxid = Integer.parseInt( result.get( result.size() - 1 ).get("ID") );

		System.out.println( maxid);

		SyuukanModel utm = new SyuukanModel();

		utm.setKaisuu(count);

		//INSERT文の発行
		/*
		StringBuilder sql = new StringBuilder("UPDATE INTO HistoryTable (");

		//DBのINSERTする項目名
		sql.append("kaisuu");

		//DBへINSERTする値
		sql.append(")VALUES(");

		sql.append("'" + utm.getKaisuu() + "'");
		sql.append(");");
		*/

		String updatesql = "UPDATE HistoryTable SET kaisuu = "
		+ counter.getText() + " WHERE ID = " + maxid + ";";
		db.insert(updatesql);


		TitleView view = new TitleView();
		view.ShowView(null);
	}

	@FXML
	void Btn_count(ActionEvent e) {
		counter.setText(String.valueOf(count++));

		if (count == 31) {
			count = 1;

			num++;
	}




		 Arc arc = new Arc(0, 0, circle.getRadius(), circle.getRadius(),
		        360.0 / 30 * count_2, 360.0 / 30);
		        arc.setLayoutX(circle.getLayoutX());
		        arc.setLayoutY(circle.getLayoutY());
		        arc.setType(ArcType.ROUND);
		        arc.setFill(Color.DEEPSKYBLUE);
		        arc.setStroke(Color.GRAY);
		        root.getChildren().add(arc);

		        count_2++;



	}



	/* @FXML protected void onButtonClick() {
	        Arc arc = new Arc(0, 0, circle.getRadius(), circle.getRadius(),
	            360.0 / 9 * count, 360.0 / 9);
	        arc.setLayoutX(circle.getLayoutX());
	        arc.setLayoutY(circle.getLayoutY());
	        arc.setType(ArcType.ROUND);
	        arc.setFill(Color.DODGERBLUE);
	        arc.setStroke(Color.BLACK);
	        root.getChildren().add(arc);

	        count++;

	        progressIndicator.setProgress(1.0 / 9 * count);
	    }*/
	@FXML
	void Btn_history(ActionEvent e) {

		HistoryView view = new HistoryView();
		view.ShowView(null);
	}

	@FXML
	void Btn_return2(ActionEvent e) {

		TargetView view = new TargetView();
		view.ShowView(null);
	}

	@FXML
	void Btn_return3(ActionEvent e){
		TitleView view = new TitleView();
		view.ShowView(null);
	}


}
