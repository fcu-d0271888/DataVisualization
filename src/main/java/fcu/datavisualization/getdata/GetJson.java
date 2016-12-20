package fcu.datavisualization.getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
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
        JSONArray output = new JSONArray(jsonText);
        System.out.println(output.getJSONObject(0).getJSONObject("commit"));
        System.out.println(output.getJSONObject(0).getJSONObject("commit").getJSONObject("author").getString("date"));
        return output.getJSONObject(0).getJSONObject("commit").getJSONObject("author");
        
      } finally {
        is.close();
      }	  	
  }
  
  public int GetDate(String Day) throws IOException, JSONException, ParseException{
	    JSONObject json = readJsonFromUrl("https://api.github.com/repos/fcu-d0271888/WP-HW1/commits");
	    String date = (String) json.getString("date").subSequence(0, 10);  //日期
	    String time = (String) json.getString("date").subSequence(11, 19); //時間
	    String DateTime = date + " " + time;
	    System.out.println(date);
	    System.out.println(time);
	    System.out.println(DateTime);
	    System.out.println("時間");
	    System.out.println(json.getString("date"));
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date a = sdf.parse(DateTime);
	    Date c = sdf.parse(Day);
	   
	    
	    if(a.getTime() > c.getTime()){
	    	System.out.println("遲交");
	    	return 1;
	    }
	    else{
	    	System.out.println("在期限內繳交");
	    	return 0;
	    }
	  }
  
  /*public static Date transform(String Day) throws ParseException{
	  SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  return sdfa.parse(Day);
  }*/
  

  public static void main(String[] args) throws IOException, JSONException, ParseException {
    JSONObject json = readJsonFromUrl("https://api.github.com/repos/fcu-d0271888/WP-HW1/commits");
    String date = (String) json.getString("date").subSequence(0, 10);  //日期
    String time = (String) json.getString("date").subSequence(11, 19); //時間
    String DateTime = date + " " + time;
    System.out.println(date);
    System.out.println(time);
    System.out.println(DateTime);
    System.out.println("時間");
    System.out.println(json.getString("date"));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date a = sdf.parse(DateTime); 
    System.out.println(a);
   // Date b = GetDate("2016-09-21 15:32:55");
    //System.out.println("**" + transform("2016-09-21 15:32:55"));
    
    int ontime = 0;
    int late = 0;
    System.out.println("test" + 1);
   /* if(a.getTime() > b.getTime()){
    	System.out.println("遲交");
    	late++;
    }
    else{
    	System.out.println("在期限內繳交");
    	ontime++;
    }
  }*/
}
}
