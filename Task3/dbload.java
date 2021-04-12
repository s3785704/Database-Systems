//Manav -s3785704
import java.io.*;
import java.math.*;

class dbload{
  public static byte[] get_string_byte(String str){
     return  str.getBytes(); 
  }

  public static byte[] get_num_byte(String str){
     BigInteger big = new BigInteger(str);
     return big.toByteArray();
  }

  public static void main(String[] args){
	  int total_pages_written = 0;
    try{
	  byte [] record = new byte[104];
	  byte [] page = new byte[1024];
	  FileReader fr = new FileReader(args[2]);
	  BufferedReader br = new BufferedReader(fr);
	  String line;
	  String[] arrStr ;
	  int i,j =0;
	  int page_beg =0;
	  int records = 0;
	  OutputStream outputStream = new FileOutputStream("heap.1024");

	  while((line = br.readLine()) != null ){
	    j = j +1;
		if(j ==1 ) continue;
		arrStr = line.split(",");
		for(String a: arrStr){
			System.out.println(a);
		}
		//ID field is 4 bytes 
		byte [] bytes;
	  	//System.out.println("BYTES = "+bytes[0]);
	  	//System.out.println("BYTES = "+a);
		int rec=0;
		bytes = get_num_byte(arrStr[0]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//Date_time
		bytes = get_string_byte(arrStr[1]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//year
		bytes = get_num_byte(arrStr[2]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//Month
		bytes = get_string_byte(arrStr[3]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//Mdate
		bytes = get_num_byte(arrStr[4]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//Day
		bytes = get_string_byte(arrStr[5]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		  }
		//TIme
		bytes = get_num_byte(arrStr[6]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//SensorID
		bytes = get_num_byte(arrStr[7]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		//Sensor_Name
		bytes = get_string_byte(arrStr[8]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		  }
		//Hourly Counts
		bytes = get_num_byte(arrStr[9]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
	  	System.out.println("RECORD LEN = "+record.length);
		for(i=0;i < record.length; i++){
		  page[page_beg++] = record[i];
		}
		records++;
        
		if(records == 9){
			outputStream.write(page);
			records =0;
			page_beg = 0;
			total_pages_written++;
		}

		if (j == 20) break;
	  }
	}catch(IOException e){
	}

	  	System.out.println("PAGES = "+ total_pages_written );

  }
}
