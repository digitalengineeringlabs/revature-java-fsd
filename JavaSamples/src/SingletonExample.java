
public class SingletonExample {
	
	public static void main(String[] args) {
		
		Singleton s = Singleton.getInstance();
		Singleton x = Singleton.getInstance();//dont allow new object instantiation
		
	}

}

class Singleton {
	
	private static Singleton _instance = null;
	
	private Singleton() {
		//load the properties (file)
	}
	
	public static Singleton getInstance(){
		if(_instance == null) {
			return new Singleton();
		}
		return _instance;
	}
	
}
