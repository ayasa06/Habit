package view;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import manager.PathManager;

public class TitleView extends BaseView {

		// TODO 自動生成されたコンストラクター・スタブ
	public TitleView( ) {
		super("Title.fxml");
		// TODO 自動生成されたコンストラクター・スタブ
	}

@Override
	public void Init() {

	ImageView imageview = (ImageView) getPane().lookup("#hashiru");

	// サンプルの景色の画像のリソースの取得、media/image内に配置したもの

	File f = new File(PathManager.GetInstance().GetImagePath("tn.png"));

	// 取得した画像ファイルを画像として読み込む

	Image img = new Image(f.toURI().toString());

	// 読み込んだ画像をImageViewに設定

	imageview.setImage(img);






	}





@FXML
void onBtnContinue(ActionEvent e) {



	Pane pane = super.getPane();
	System.out.println(((TextField)pane.lookup("#title_field")).getText());





}
}
