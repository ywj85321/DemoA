package practicet1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro = new Properties();
	String value = null;
	
	public ParseProperties(String propertiespath){
		this.loadParseProperties(propertiespath);
	}
	
	private void loadParseProperties(String propertiespath) {
		try {
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyname){
		value = pro.getProperty(keyname).trim();
		try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		ParseProperties a = new ParseProperties("C:\\Users\\xy\\workspace\\TestMaven\\tool\\locators.properties");
		ParseProperties b = new ParseProperties("C:\\Users\\xy\\workspace\\TestMaven\\tool\\test.properties");
		System.out.println(a.getValue("username"));
		System.out.println(b.getValue("username"));
	}
}
