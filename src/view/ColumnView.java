package view;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import manager.PathManager;

public class ColumnView extends BaseView {
	public ColumnView() {
		super("Column.fxml");

	}
	@Override
	public void Init() {
		ImageView imageview = (ImageView) getPane().lookup("#udetate");

		// サンプルの景色の画像のリソースの取得、media/image内に配置したもの

		File f = new File(PathManager.GetInstance().GetImagePath("tn2.png"));

		// 取得した画像ファイルを画像として読み込む

		Image img = new Image(f.toURI().toString());

		// 読み込んだ画像をImageViewに設定

		imageview.setImage(img);

	

	}



}
