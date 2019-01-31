package Lz78;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sun.javafx.collections.MappingChange.Map;
public class encodingDecoding {

	public static void main(String[] args) throws Exception {
		Encoding("C:/Users/omarBassuni/Desktop/try.txt");
		decoding("Compressed.txt");

	}
	public static void Encoding(String filePath)throws Exception
	{
		String data;
		String toBeAppended;
		
	    data = new String(Files.readAllBytes(Paths.get(filePath))); 
	    Vector<String> _list = new Vector<String>();
	    Vector<Character> _tagChar = new Vector<Character>();
	    Vector<Integer> _tagNumber = new Vector<Integer>();
	    
	    
	    toBeAppended = "";
	    int lastInd = 0;
	    for(int i = 0;i < data.length();i++)
	    {
	    	toBeAppended += data.charAt(i);
	    	if(!_list.contains(toBeAppended))
	    	{
	    		_list.add(toBeAppended);
	    		_tagChar.add(toBeAppended.charAt(toBeAppended.length()-1));
	    		if(toBeAppended.length() ==  1)
	    		{
	    			_tagNumber.addElement(0);
	    		}
	    		else{
	    			_tagNumber.add(lastInd);
	    		}
	    		
	    		toBeAppended = "";
	    	}
	    	else
	    	{
	    			lastInd = i;
	    	}
	    }
	    System.out.println(_list);
	    
	    File file = new File("Compressed.txt");
	    file.createNewFile();
	    FileWriter writer = new FileWriter(file);
	    
	    for(int i = 0;i < _tagNumber.size();i++)
	    {
	    	writer.write(_tagNumber.get(i) + "," + _tagChar.get(i) + ";");
	    }
	    writer.flush();
	    writer.close();
	    
	    
	}
	
//	public static void decoding(String filePath) throws IOException
//	{
//		String[] data;
//		data = new String(Files.readAllBytes(Paths.get(filePath))).split(";");
//		String decompressed = "";
//		
//		Vector<Integer> _taggedNum = new Vector<Integer>();
//		Vector<String> _dic = new Vector<String>();
//		
//		for(int i = 0; i < data.length;i++)
//		{
//			_taggedNum.add(i);
//			
//			String[] tmp = data[i].split(",");
//			String temp = tmp[1];
//		
//			Integer index = Integer.parseInt(tmp[0]);
//			
//			System.out.println(tmp[0]);
//				
//		}
//		System.out.println(_dic);
//		
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
