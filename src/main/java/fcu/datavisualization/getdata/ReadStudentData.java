package fcu.datavisualization.getdata;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

public class ReadStudentData {

	public RSData GetNum() throws JSONException, IOException, ParseException {
		ArrayList<String> Datelist = new ArrayList<String>();
		GetJson GetDay = new GetJson();
		RSData data = new RSData();
		int output = 3;
		int LateCount = 0;
		int OntimeCount = 0;

		String test1 = "2016-09-21 15:32:55";
		Datelist.add(test1);
		String test2 = "2016-09-22 15:32:55";
		Datelist.add(test2);
		String test3 = "2016-09-21 15:32:55";
		Datelist.add(test3);
		String test4 = "2016-09-20 14:32:55";
		Datelist.add(test4);
		String test5 = "2016-09-19 15:32:55";
		Datelist.add(test5);
		String test6 = "2016-09-18 15:32:55";
		Datelist.add(test6);
		String test7 = "2016-09-19 15:32:55";
		Datelist.add(test7);

		for (int i = 0; i < 7; i++) {
//			output = GetDay.GetDate(Datelist.get(i));
			if (output == 1) {
				LateCount++;
			} else if (output == 0) {
				OntimeCount++;
			}
		}
		data.setLateCount(LateCount);
		data.setOntimeCount(OntimeCount);
		// data.setDate(GetDay.GetDate(Day));
		return data;
	}
}
