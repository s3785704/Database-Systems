//Manav -s3785704
import java.io.*;
import java.math.*;
import java.lang.*;

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
	  int page_size = Integer.parseInt(args[1]);
	  byte [] record = new byte[104];
	  byte [] page = new byte[page_size];
	  int records = 0;
	  int count =0; 
	  int i;
	  int page_beg =4;
	  int max_count =0;
	  int blocking_factor = 9;
	  byte dummy = 0;
	  byte [] bytes;
	  long start_time = 0,end_time =0;
    try{
	  FileReader fr = new FileReader(args[2]);
	  BufferedReader br = new BufferedReader(fr);
	  String line;
	  String[] arrStr ;
	  String filename = "heap." + args[1];
	  OutputStream outputStream = new FileOutputStream(filename);

	  //Calculate blocking factor 
	  float block_f = page_size/(float)103;
	  blocking_factor = Math.round((float)Math.floor(block_f));
	  //System.out.println("BF = "+blocking_factor);

	  start_time = System.currentTimeMillis();



	  while((line = br.readLine()) != null ){
	    j = j +1;
		if(j ==1 ) continue;
	    count =0; 
		arrStr = line.split(",");
		//for(String a: arrStr){
		//	System.out.println(a);
		//}
		//ID field is 4 bytes 
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
        
		if(records == blocking_factor){
		    bytes = get_num_byte(Integer.toString(blocking_factor));
			for(i=0;i < bytes.length; i++){
		  		page[i] = bytes[i];
			}
			int k;
		      for(k=0; k <  4-bytes.length;k++){
		          page[i+k] = dummy;
		      }
			outputStream.write(page);
			records =0;
			page_beg = 4;
			total_pages_written++;
		}

		if(count > max_count){
		  max_count = count;
		}

		//if(j % 1000 == 0){
	  	  // System.out.println("Processed  "+ j);
		//}

	  }
	     if(records > 0 ){
		    bytes = get_num_byte(Integer.toString(records));
			for(i=0;i < bytes.length; i++){
		  		page[i] = bytes[i];
			}
			int k;
		      for(k=0; k <  4-bytes.length;k++){
		          page[i+k] = dummy;
		      }
			outputStream.write(page);
			records =0;
			page_beg = 4;
			total_pages_written++;
		 }
	    end_time = System.currentTimeMillis();
	  	//System.out.println("Max Count  "+ max_count );
	}catch(IOException e){
	  	System.out.println("Exception happened"+ j );
	}

	  	System.out.println("Page Size         = "+ page_size );
	  	System.out.println("Total pages       = "+ total_pages_written );
	  	System.out.println("Records Processed = "+ (j-1) );
	  	System.out.println("Time taken        = "+ (end_time - start_time) + " milliseconds" );

  }
}
