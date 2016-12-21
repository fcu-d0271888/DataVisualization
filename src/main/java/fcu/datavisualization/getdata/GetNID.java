package fcu.datavisualization.getdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetNID {
	
	public ArrayList NID() throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		FileReader fr = new FileReader("/Users/Eason/Desktop/NID.txt");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			list.add(br.readLine());
         //   System.out.println(br.readLine());
		}
			fr.close();
		return list;
	}
	
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		FileReader fr = new FileReader("/Users/Eason/Desktop/NID.txt");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			list.add(br.readLine());
            //System.out.println(br.readLine());
		}
		fr.close();		
		for(int i = 0;i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
}
