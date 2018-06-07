package dataDog;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadFiles {     
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	    	
	        Files.copy(in, Paths.get(fileName));
	        System.out.println("Downloaded!");
	    }
	}

    public static void main(String[] args) throws Exception {
    	
    		for(int i=1871;i<=2014;i++){
    		String url = "https://s3.amazonaws.com/dd-interview-data/data_scientist/baseball/appearances/"+i+"/"+i+"-0,000";
    		String fileName = "./"+i;
            download(url,fileName);
    		}
        
    }
}
