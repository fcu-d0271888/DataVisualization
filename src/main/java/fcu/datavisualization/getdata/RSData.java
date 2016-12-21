package fcu.datavisualization.getdata;

import java.util.ArrayList;

public class RSData {
	private int LateCount;
	private int OntimeCount;
	private int NotCount;
	private ArrayList<String> list;
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public int getNotCount() {
		return NotCount;
	}

	public void setNotCount(int notCount) {
		NotCount = notCount;
	}

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getLateCount() {
		return LateCount;
	}

	public void setLateCount(int lateCount) {
		LateCount = lateCount;
	}

	public int getOntimeCount() {
		return OntimeCount;
	}

	public void setOntimeCount(int ontimeCount) {
		OntimeCount = ontimeCount;
	}

}
