package manager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIManager {
	public static void GetAPIWhether() {
		try {

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://community-open-weather-map.p.rapidapi.com/find?q=koriyama&cnt=1&mode=null&lon=0&type=link%2C%20accurate&lat=0&units=imperial%2C%20metric"))
					.header("x-rapidapi-key", "c613c7351bmsh9279ccfdf0a6733p16fb3bjsn9018a7acca74")
					.header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			
			
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

			// URLレスポンスコードの取得
			int responseCode = response.statusCode();

			// レスポンスコードが正常であればURLボディの取得
			if (responseCode == HttpURLConnection.HTTP_OK) {

            	// com.fasterxml.jackson.databind.ObjectMapperを使います
            	ObjectMapper mapper = new ObjectMapper();
            	// キーがString、値がObjectのマップに読み込みます。

            	// 連想配列のように扱えるJsonNode型にデータを入れる
        		JsonNode node = mapper.readTree(response.body());

        		// 情報の表示
        		System.out.println(node.get("list").get(0).get("name").asText());

			} else {
				System.out.println("取得失敗");
			}
		} catch (MalformedURLException e) {
			// URL接続エラー
			e.printStackTrace();
		} catch (ProtocolException e) {
			// プロトコル通信エラー
			e.printStackTrace();
		} catch (IOException e) {
			// 標準入出力エラー
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}}