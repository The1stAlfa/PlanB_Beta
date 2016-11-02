import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import com.google.gson.Gson;  
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Table;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.TableQueryModel;

public class HttpClientExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpClientExample http = new HttpClientExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "https://spreadsheets.google.com/tq?&tq=&key=1Xkd22LiN9unvv7GYOqsv3XwvjVMbFsi-EZASg4hxF9E&sheet=action";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " +
                       response.getStatusLine().getStatusCode());
                
		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
                line = rd.readLine();
		while ((line = rd.readLine()) != null) {
                    result.append(line);
		}
                Pattern pattern = Pattern.compile(".\\((.*?)\\);");
                Matcher matcher = pattern.matcher(result.toString());
                matcher.find();
                System.out.println(matcher.group(1)+"\n\n");
                String [] g = result.toString().split("google.visualization.Query.setResponse\\(");
                //JSONObject obj = new JSONObject(g[1].substring(0, g[1].length()-2));
                //String pageName = obj.getJSONObject("pageInfo").getString("pageName");

                Gson gson = new Gson();
                TableQueryModel tm = gson.fromJson(matcher.group(1), TableQueryModel.class);
                Table t = tm.getTable();
                System.out.println(t.toString());
                /*
                JSONObject table = obj.getJSONObject("table");
                JSONArray arr = table.getJSONArray("rows");
                for (int i = 0; i < arr.length(); i++)
                {
                    //String c = arr.getJSONObject(i).getString("c");
                    System.out.println(arr.get(i).toString());
                }*/
                
	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " +
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}

}