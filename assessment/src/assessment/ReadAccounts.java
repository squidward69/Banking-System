package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
	private String filePath;
	
	public ReadAccounts(String filePath) {
		this.filePath=filePath;
	}

	public LinkedList<String> getFirstNames(){
		LinkedList<String> firstNames = new LinkedList<String>();
		try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
			String line;
			while((line=br.readLine())!= null) {
				String[] data= line.split(",");
				firstNames.add(data[0]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return firstNames;
	}
	
	public LinkedList<String> getLastNames(){
		LinkedList<String> lastNames = new LinkedList<String>();
		try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
			String line;
			while((line=br.readLine())!= null) {
				String[] data= line.split(",");
				lastNames.add(data[1]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return lastNames;
	}
	
	public LinkedList<Integer> getAccounts(){
		LinkedList<Integer> accounts = new LinkedList<Integer>();
		try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
			String line;
			while((line=br.readLine())!= null) {
				String[] data= line.split(",");
				accounts.add(Integer.parseInt(data[2]));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public LinkedList<Integer> getBalances(){
		LinkedList<Integer> balances= new LinkedList<Integer>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line=br.readLine())!=null) {
				String[] data= line.split(",");
				balances.add(Integer.parseInt(data[3]));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return balances;
	}
	
}
