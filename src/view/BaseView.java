	package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import manager.PathManager;
import model.BaseModel;

public abstract class BaseView {

	String m_filename;
	Pane m_pane;
	static private Stage m_Stage;
	static private BaseModel m_model;

	// コンストラクター
	public BaseView(String filename) {
		m_filename = filename;
	}

	// Stageセッター
	public static void setStage(Stage stage) {
		m_Stage = stage;
	}

	// Paneゲッター
	public Pane getPane() {
		return m_pane;
	}

	// Modelゲッター
	static public BaseModel getModel() {
		return m_model;
	}

	// ビューの表示
	public void ShowView(BaseModel model) {

		// fxmlファイル読込用のストリーム
		InputStream i = null;

		try

		{
			// ページに渡されてきたモデル（情報）の代入
			m_model = model;

			// fxmlファイルの読込
			File file = new File(PathManager.GetInstance().GetFXMLPath(m_filename));
			i = new FileInputStream(file);

			// 読み込んだfxmlファイル(変数i)からルートを作成
			m_pane = new FXMLLoader().load(i);

			//Sceneの設定
			Scene scene = new Scene(
					getPane(),
					getPane().getPrefWidth(),
					getPane().getPrefHeight()

			);

			//CSS設定
			 m_pane.getStylesheets().add( new URL("file:///" + PathManager.GetInstance().GetFXMLPath("style.css")).toExternalForm() );



			//ステージ（ウインドウ）にページを適応
			m_Stage.setScene(scene);

			//ステージ（ウインドウ）を表示
			m_Stage.show();

			//初期化処理、それぞれのページのViewクラスの関数Initが呼ばれる
			Init();

		} catch (Exception e) {
			System.out.println("BaseView:NextView() 例外発生");
			e.printStackTrace();

		} finally {

			//ストリームを閉じる

			try {

				if (i != null) {

					i.close();

				}

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	abstract public void Init();

}
