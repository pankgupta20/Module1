import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;


public class XMLHandling {

	
	static String endpoint = "http://actimruatxagv01/wcl/inbox/rlc2015.aspx";
	public static void main(String[] args) throws ClientProtocolException, IOException {
		  File requestFile = new File(System.getProperty("C://Selenium//Module 1//seleniumrc//Screenshots//ILUOP1.xml"));
		  HttpClient client = HttpClientBuilder.create().build();
		  HttpPost post = new HttpPost(endpoint);
		  post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		  post.setHeader("Content-type","text/xml");
		  HttpResponse response = client.execute(post);
		  BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		  String line = "";
		  StringBuffer sb = new StringBuffer();
		  while((line=br.readLine())!=null)
			  sb.append(line);
	}
	
/*	PrintWriter pw = new PrintWriter(System.getProperty("//Module 1//seleniumrc//Screenshots//Response.xml"));
			pw.
			pw.clo
			*/
		  
		  
		  
		

	
	}

