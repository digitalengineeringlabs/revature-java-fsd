
public class ExtensibleExample {
	
	public static void main(String[] args) {

		String delimiter = ":";
		String data = "Apple:Banana:Grapes";
		//String data = "Apple&Banana&Grapes";
		//String data = "Apple#Banana#Grapes";
		
		//Design Pattern
		// 1. Creational Pattern
		
		// Factory
		// AbstractFactory
		// Singleton
		// Proxy
		
		//2. Structural
		//3. Behavioral
				
		DataParser parser = ParserFactory.getParser(delimiter);

		String[] parsed = parser.parse(data);
		
		
		for(String d : parsed) {
			System.out.println(d);
		}
		
	}

}

//Factory Pattern
class ParserFactory {
	
	public static DataParser getParser(String key) {
		DataParser parser = null;
		if("&".equals(key)) {
			parser = new DollarDataParser();
		}
		else if ("#".equals(key)) {
			parser = new HashDataParser();
		}
		else if (":".equals(key)) {
			parser = new PipeDataParser();
		}
		return parser;
	}
	
}

interface DataParser {
	String[] parse(String data);
}

class PipeDataParser implements DataParser {

	public String[] parse(String data) {
		return data.split(":"); //regex
	}
	
}

class HashDataParser implements DataParser {

	public String[] parse(String data) {
		return data.split("#"); //regex
	}
	
}

class DollarDataParser implements DataParser {

	public String[] parse(String data) {
		return data.split("&"); //regex
	}
	
}