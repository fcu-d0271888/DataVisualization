package fcu.datavisualization.getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class GetJson {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    
    try {
    	
 	
    	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        jsonText = "{output:" + jsonText + "}";
        //System.out.println("字串");
        //System.out.println(jsonText);
        
        /*while((rd.readLine()) != null){
        	jsonText.replace("[", " ").replace("]", " ");
        }*/
        
        JSONObject json = new JSONObject(jsonText);
        Object o = json.get("output");
        return json;
      } finally {
        is.close();
      }	
    	
  }

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://api.github.com/repos/FoodOrder/Eclipse/commits");
    System.out.println("JSON");
    System.out.println(json.toString());
  }
}
