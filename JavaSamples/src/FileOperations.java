import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
	
	public static void main(String[] args) {
		
		String fileName = "/Volumes/Data HD/Workspace/sts2/JavaExercises/src/data.txt";
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(fileName);
			int i;
			
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException ignored) {}
		}
		
		System.out.println();
		
		File f = new File("/Volumes/Data HD/Workspace/sts2/JavaExercises/src");
		if(f.isDirectory()) {
			System.out.println("it is not file");
			File[] files = f.listFiles();
			for(File file : files) {
				System.out.println(file.getAbsolutePath());
			}
		}
		
	}

}
