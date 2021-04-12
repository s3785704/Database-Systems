//Manav -s3785704
import java.io.*;

class dbload{
  public static void main(String[] args){
    try{
	  FileReader fr = new FileReader(args[2]);
	  BufferedReader br = new BufferedReader(fr);
	  String line;
	  String[] arrStr ;
	  int i =0;
	  while((line = br.readLine()) != null ){
	    i = i +1;
		arrStr = line.split(",");
		for(String a: arrStr){
			System.out.println(a);
		}
		if (i == 1) break;
	  	//System.out.println(line);
	  }
	}catch(IOException e){
	}
  }
}
