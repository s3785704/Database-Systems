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
	  int j = 0;
    try{
	  int page_size = Integer.parseInt(args[1]);
	  byte [] record = new byte[104];
	  byte [] page = new byte[page_size];
	  FileReader fr = new FileReader(args[2]);
	  BufferedReader br = new BufferedReader(fr);
	  String line;
	  String[] arrStr ;
	  int i;
	  int page_beg =4;
	  int records = 0;
	  int count =0; 
	  int max_count =0;
	  OutputStream outputStream = new FileOutputStream("heap.1024");



	  while((line = br.readLine()) != null ){
	    j = j +1;
		if(j ==1 ) continue;
	    count =0; 
		arrStr = line.split(",");
		//for(String a: arrStr){
		//	System.out.println(a);
		//}
		//ID field is 4 bytes 
		byte [] bytes;
		byte dummy = 0;
	  	//System.out.println("BYTES = "+bytes[0]);
	  	//System.out.println("BYTES = "+a);
		int rec=0;
		bytes = get_num_byte(arrStr[0]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Date_time
		bytes = get_string_byte(arrStr[1]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  24-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//year
		bytes = get_num_byte(arrStr[2]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Month
		bytes = get_string_byte(arrStr[3]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  9-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Mdate
		bytes = get_num_byte(arrStr[4]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Day
		bytes = get_string_byte(arrStr[5]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		  }
		count += bytes.length;
		for(i=0; i <  8-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//TIme
		bytes = get_num_byte(arrStr[6]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//SensorID
		bytes = get_num_byte(arrStr[7]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Sensor_Name
		bytes = get_string_byte(arrStr[8]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		  }
		count += bytes.length;
		for(i=0; i <  38-bytes.length;i++){
		  record[rec++] = dummy;
		}
		//Hourly Counts
		bytes = get_num_byte(arrStr[9]);
		for(i=0;i < bytes.length; i++){
		  record[rec++] = bytes[i];
		}
		count += bytes.length;
		for(i=0; i <  4-bytes.length;i++){
		  record[rec++] = dummy;
		}
		for(i=0;i < record.length; i++){
		  page[page_beg++] = record[i];
		}
		records++;
        
		if(records == 9){
		    bytes = get_num_byte(Integer.toString(9));
			for(i=0;i < bytes.length; i++){
		  		page[i] = bytes[i];
			}
			int k;
		      for(k=0; k <  4-bytes.length;k++){
		          page[i+k] = dummy;
		      }
			outputStream.write(page);
			records =0;
			page_beg = 0;
			total_pages_written++;
		}

		if(count > max_count){
		  max_count = count;
		}

		if(j % 1000 == 0){
	  	   System.out.println("Processed  "+ j);
		}

	  }
	  	System.out.println("Max Count  "+ max_count );
	}catch(IOException e){
	  	System.out.println("Exception happened"+ j );
	}

	  	System.out.println("PAGES = "+ total_pages_written );
	  	System.out.println("Records Processed = "+ j );

  }
}
