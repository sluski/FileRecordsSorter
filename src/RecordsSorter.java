import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RecordsSorter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter path to txt file: ");
		String path = input.nextLine();
		BufferedReader  bufferedReader = null;
		FileReader fileReader = null;
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;

		List<String> fileAsList = new ArrayList<>();
		boolean isOperation = true;
		List<String> tempList = new ArrayList<>();
		
		try {
		    fileReader = new FileReader(path);
		    bufferedReader = new BufferedReader(fileReader);
			String line;
			
		    while ((line = bufferedReader.readLine()) != null) {
		    	fileAsList.add(line);
		    }
		    bufferedReader.close();
		}catch(IOException ex){
			System.out.println(ex);
		}
		
		while(isOperation){
			isOperation = false;
			String temp = "";
			for(int i  = 0; i < fileAsList.size()-1; i++){
				if((int)fileAsList.get(i).charAt(0) > (int)fileAsList.get(i+1).charAt(0)){
					temp = fileAsList.get(i);
					fileAsList.set(i, fileAsList.get(i+1));
					fileAsList.set(i+1, temp);
					isOperation = true;
				}
			}
		}
		
		try{
			fileWriter = new FileWriter(path);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(String sLine : fileAsList){
				bufferedWriter.write(sLine);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
				
		}catch(IOException ex){
			System.out.println(ex);
		}
		
	}
}
