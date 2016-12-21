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
			//System.out.println(output.getJSONObject(0).getJSONObject("commit"));
			//System.out.println(output.getJSONObject(0).getJSONObject("commit").getJSONObject("author").getString("date"));
			return output.getJSONObject(0).getJSONObject("commit").getJSONObject("author");

		} finally {
			is.close();
		}
	}

	public RSData GetDate() throws IOException, JSONException, ParseException {
		GetNID GetNID = new GetNID();
		RSData RSData = new RSData();
		
		int LateCount = 0;
		int OntimeCount = 0;
		int NotCount = 0;
		int i = 0;
		for(i = 0; i < GetNID.NID().size(); i++){
			
			try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date c = sdf.parse("2016-09-20 23:59:59");
					
					JSONObject json = readJsonFromUrl("https://api.github.com/repos/fcu-" + GetNID.NID().get(i) + "/WP-HW1/commits");
					String date = (String) json.getString("date").subSequence(0, 10); // 日期
					String time = (String) json.getString("date").subSequence(11, 19); // 時間
					String DateTime = date + " " + time;
					//System.out.println(date);
					//System.out.println(time);
					System.out.println(DateTime);
					/*System.out.println("交作業時間");
					System.out.println(json.getString("date"));*/
					
					Date a = sdf.parse(DateTime);
					
	
					if (a.getTime() < c.getTime()) {
						System.out.println(GetNID.NID().get(i) + "遲交");
						LateCount++;
					} else {
						System.out.println(GetNID.NID().get(i) + "在期限內繳交");
						OntimeCount++;
					}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			}
		}
		RSData.setLateCount(LateCount);
		RSData.setOntimeCount(OntimeCount);
		RSData.setNotCount(NotCount);
		System.out.println("準時：" + RSData.getOntimeCount());
		System.out.println("遲交：" + RSData.getLateCount());
		System.out.println("未交：" + RSData.getNotCount());
		return RSData;
	}


	/*public static void main(String[] args) throws IOException {
		GetNID GetNID = new GetNID();
		RSData RSData = new RSData();
		
		int LateCount = 0;
		int OntimeCount = 0;
		int NotCount = 0;
		int i = 0;
		for(i = 0; i < GetNID.NID().size(); i++){
			
			try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date c = sdf.parse("2016-09-20 23:59:59");
					
					JSONObject json = readJsonFromUrl("https://api.github.com/repos/fcu-" + GetNID.NID().get(i) + "/WP-HW1/commits");
					String date = (String) json.getString("date").subSequence(0, 10); // 日期
					String time = (String) json.getString("date").subSequence(11, 19); // 時間
					String DateTime = date + " " + time;
					//System.out.println(date);
					//System.out.println(time);
					System.out.println(DateTime);
					System.out.println("交作業時間");
					System.out.println(json.getString("date"));
					
					Date a = sdf.parse(DateTime);
					
	
					if (a.getTime() < c.getTime()) {
						System.out.println("遲交");
						LateCount++;
					} else {
						System.out.println("在期限內繳交");
						OntimeCount++;
					}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(GetNID.NID().get(i) + "未交作業");
				NotCount++;
			}
		}
		RSData.setLateCount(LateCount);
		RSData.setOntimeCount(OntimeCount);
		RSData.setNotCount(NotCount);
		System.out.println("準時：" + RSData.getOntimeCount());
		System.out.println("遲交：" + RSData.getLateCount());
		System.out.println("未交：" + RSData.getNotCount());
	}*/
}
