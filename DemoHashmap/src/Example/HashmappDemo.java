package Example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashmappDemo {

	public static HashMap h = new HashMap();
	// tim file trong folder
	public static void addtoHashMap (File filename){
		FileInputStream fin;
		try{
			fin = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			String n;
			try{
				while ((n = br.readLine()) != null){
					if(h.containsKey(n)){
						int i = (Integer) h.get(n);
						h.put(n, (i+1));
					}else{
						h.put(n, 1);
					}
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	// kiem tra folder trong folder
	public void isfolder(File findfile){
		if(findfile.isDirectory()){
			System.out.println(findfile + "is a directory");
			String[] directoryContents = findfile.list();
			for(int i = 0; i < directoryContents.length; i++){
				File newpath = new File(findfile + "/" + directoryContents[i]);
				isfolder(newpath);
						
			}
		}else{
			HashmappDemo.addtoHashMap(findfile);
		}
		
	}
	
	
	// kiem tra folder
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathname = "F:/Listerning";
		File file = new File(pathname);
		String[] directoryContents = file.list();
		HashmappDemo ifs = new HashmappDemo();
		for (int i = 0; i < directoryContents.length; i++){
			File newpath = new File(pathname + "/" + directoryContents[i]);
			ifs.isfolder(newpath);
		}
	}

}
