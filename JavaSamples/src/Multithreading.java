import java.util.ArrayList;
import java.util.List;

public class Multithreading {

	public static void main(String[] args) throws Exception {
		//using Thread class
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		w1.start();
//		w1.join();
		w2.start();
		
		/* using Runnable Interface */
		
//		Thread t1 = new Thread(new TaskExecutor());
//		Thread t2 = new Thread(new TaskExecutor());
//		t1.start();
//		t2.start();
		
		
		//Using Runnable with Lambda expression
		Thread t = new Thread(()->System.out.println("Test"));
		t.start();
	}
}

class Worker extends Thread {
	
	List<String> sharedResource = new ArrayList<String>();
	
	
	@Override
	public void run() {
		System.out.println("Running thread ["+getName()+"] ...");
		for (int i = 0; i < 5; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {}
			System.out.println("["+getName()+"] " + i);
		}
	
		synchronized(sharedResource) {
		
			registerUser();
		}
	}
	
	
	void registerUser(){
		//data read 
		sharedResource.add("Test");
		//and update is done
	}
	
}

class TaskExecutor implements Runnable {

	@Override
	public void run() {
		System.out.println("Running thread ...");
	}
	
}