package manager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManager {
	private static Path MEDIA_PATH;

	// mediaフォルダへのパスを確認できたか

	private boolean isMediaPathSuccess = false;

	// シングルトンクラスのインスタンス本体

	private static PathManager m_instance = new PathManager();





	public static PathManager GetInstance(){

	return m_instance;

	}



	// 外部からコンストラクタを隠ぺい

	// 絶対パスを検索、カレントディレクトリ（実行フォルダ）

	// もしくはbinフォルダ内のmediaフォルダを検索

	private PathManager() {

	// カレントディレクトリのパス

	Path currentpath = Paths.get("").toAbsolutePath();

	Path tmppath = Paths.get( currentpath.toString() + "/media" );

	File file = new File(tmppath.toString());

	if(file.exists()) {

	// mediaフォルダがカレントディレクトリ内に存在

	MEDIA_PATH = tmppath;

	return ;

	}



	tmppath = Paths.get( currentpath.toString() + "/bin/media" );

	file = new File(tmppath.toString());

	if(file.exists()) {

	// mediaフォルダがbinフォルダ内に存在

	MEDIA_PATH = tmppath;

	return ;

	}



	System.out.println("mediaフォルダが見つかりませんでした");

	System.out.println("mediaフォルダ検索：" + currentpath.toString());



	}



	private boolean IsFileExists(String dirname, String filename) {

	File file = new File( MEDIA_PATH.toString() + "/" + dirname + "/" + filename );



	// 検索したファイルが見つからなかった

	if( !file.exists() ) {

	System.out.println( file.toString() + "  : は存在しません");

	return false;

	}



	// 検索したファイルが見つかった

	return true;

	}



	// fxmlファイルのパス文字列の取得

	public String GetFXMLPath(String filename ) {

	String dirname = "fxml";

	// ファイルが存在するかを確認
	if( !IsFileExists( dirname, filename ) ) {

		return null;

		}



		// 検索したファイルが見つかった場合はパスを文字列にして返す

		return MEDIA_PATH.toString() + "/" + dirname + "/" + filename;

		}



		// BGMSEファイルのパス文字列の取得

		public String GetBGMSEPath(String filename ) {

		String dirname = "bgmse";

		// ファイルが存在するかを確認

		if( !IsFileExists( dirname, filename ) ) {

		return null;

		}



		// 検索したファイルが見つかった場合はパスを文字列にして返す

		return MEDIA_PATH.toString() + "/" + dirname + "/" + filename;

		}



		// Imageファイルのパス文字列の取得

		public String GetImagePath(String filename ) {

		String dirname = "image";

		// ファイルが存在するかを確認

		if( !IsFileExists( dirname, filename ) ) {

		return null;

		}



		// 検索したファイルが見つかった場合はパスを文字列にして返す

		return MEDIA_PATH.toString() + "/" + dirname + "/" + filename;

		}
		// Movieファイルのパス文字列の取得

		public String GetMoviePath(String filename ) {

		String dirname = "movie";

		// ファイルが存在するかを確認

		if( !IsFileExists( dirname, filename ) ) {

		return null;

		}



		// 検索したファイルが見つかった場合はパスを文字列にして返す

		return MEDIA_PATH.toString() + "/" + dirname + "/" + filename;

		}

}




