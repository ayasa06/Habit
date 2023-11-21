package application;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import dbmanager.AccessManager;
import javafx.application.Application;
import javafx.stage.Stage;
import view.BaseView;
import view.TitleView;

public class Main extends Application {

	//javafxの起動処理が終わって始めにくるメソッド
	@Override
	public void start(Stage primaryStage) {

		InputStream i;
		try {

			BaseView.setStage(primaryStage);

			TitleView view = new TitleView();
			view.ShowView(null);

			/*
				//DBにINSERTをする処理


						SyuukanModel utm =new SyuukanModel();



			utm.setTarget(TopViewcontroller.targetString);
						utm.setEnthusiasm(TopViewcontroller.enthusiasmString);

						//INSERT文の発行
						StringBuilder sql=new StringBuilder("INSERT INTO UserTable(");

						//DBのINSERTする項目名
						sql.append("target,enthusiasm");

						//DBへINSERTする値
						sql.append(")VALUES(");

						sql.append("'"+utm.getTarget()+"'");
			sql.append(",");
			sql.append("'"+utm.getEnthusiasm()+"'");
			sql.append(",");

			AccessManager db= new AccessManager("db.accdb");
			db.insert(sql.toString());*/

			AccessManager dbm = new AccessManager("db.accdb");

			String Sql = "SELECT * FROM HistoryTable";
			String[] columns = { "aim", "enthusiasm","kaisuu" };

			ArrayList<HashMap<String, String>> result = dbm.select(Sql, columns);

			//System.out.println(result.get(0).get("target"));


			/*APIManager.GetAPIWhether();*/

			//fxmlファイル(SceanBuilderで作成した画面ファイル)を読込
			// fxmlファイルの読込

			/*File file = new File( PathManager.GetInstance().GetFXMLPath("Main.fxml") );

			i = new FileInputStream( file );

			//fxmlファイルを基にアプリの画面を作成
			Pane root =new FXMLLoader().load(i);
			Scene scene = new Scene(root,400,400);

			//CSSファイル(配置したノードのプロパティの情報)を読込、適応
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//ステージに(ウィンドウ)にシーン(ページ)を設定
			primaryStage.setScene(scene);
			primaryStage.show();//ステージを表示する

			TextArea textarea =(TextArea)root.lookup("#inputtext");
			textarea.setText("Hello World");

			Button btnSave = (Button)root.lookup("#btnsave");
			btnSave.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent args0) {
					System.out.println(textarea.getText());
				}
			})


			*/} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
