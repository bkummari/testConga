package Scenarios;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.research.ws.wadl.Response;

public class Scenario3 {
	public WebResource webResource;
	public Client client;
	public ClientResponse response;
	public static String id;
	public static String name;
	public static String id1;
	public static String name1;
	public static String apikey;
	public static String Value;
	public apiutils ap= new apiutils();
	
	

	// POST 401
    @Test(priority = 1)
	public void test1() throws Exception {
		
		String serviceresponse;
		String RESTFilePath = ap.xDownloadFiles("Post");
	client = Client.create();
	webResource = client.resource("http://api.openweathermap.org/data/3.0/stations");
	response = webResource
			.accept("application/json")
			.type("application/json")
			.post(ClientResponse.class);
	System.out.println(response.getStatus());
    
	if (response.getStatus() == 401) {
		Assert.assertTrue(true, "api Getting response of:- " + response + "");
	}
	if (response.getStatus() == 500 || response.getStatus() == 404 || response.getStatus() == 403
			|| response.getStatus() == 400 || response.getStatus() == 409) {
		Assert.assertFalse(true, "api Getting response of:- " + response + "");
	}
	
	serviceresponse = response.getEntity(String.class);
	System.out.println(serviceresponse);
	}
	
	//POST 200
    @Test(priority = 2)
	public void test2() throws Exception {
		String serviceresponse;
		apikey="27e57ddee70cf1556662bce5a2184f30";
		String RESTFilePath = ap.xDownloadFiles("Post");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appid",apikey);
		 id= "DEMO_TEST001";
		 name="Interview Station" + 8996;
		 String payload= "{\r\n" + "\"external_id\":\""+ id + "\",\r\n" + 
				"\"name\": \""+ name + "\",\r\n"
				+ "\"latitude\": 33.33,\r\n" + 
				"\"longitude\": -111.43,\r\n" + 
				"\"altitude\": 444 \r\n" + 
				"}\r\n" + "";
		  id1= "Interview1 ";
		  name1="Interview Station" + 4896;
		String payload1= "{\r\n" + "\"external_id\":\""+ id1 + "\",\r\n" + 
				"\"name\": \""+ name1 + "\",\r\n"
				+  "\"latitude\": 33.33,\r\n" + 
				"\"longitude\": -111.43,\r\n" + 
				"\"altitude\": 444 \r\n" + 
				"}\r\n" + "";
	for(int i=0;i<=1;i++) {
	if(i==1) {
		payload=payload1;
	}
	System.out.println(payload);
	client = Client.create();
	webResource = client.resource("http://api.openweathermap.org/data/3.0/stations");
	response = webResource
			.queryParams(params)
			.accept("application/json")
			.type("application/json")
			.post(ClientResponse.class,payload);
	
	if (response.getStatus() == 500 || response.getStatus() == 404 || response.getStatus() == 403
			|| response.getStatus() == 401 || response.getStatus() == 400 || response.getStatus() == 409) {
		Assert.assertFalse(true, "api Getting response of:- " + response + "");
	}
	
	if (response.getStatus() == 200 || response.getStatus() == 201) {
		Assert.assertTrue(true, "api Getting response of:- " + response + "");
	}
			serviceresponse = response.getEntity(String.class);
			System.out.println(serviceresponse);
	}
	}
	//get
    @Test(priority = 3)
	public void test3() throws Exception {
		String serviceresponse;
		apikey="27e57ddee70cf1556662bce5a2184f30";
		String RESTFilePath = ap.xDownloadFiles("APIget");
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("appid",apikey);
		client = Client.create();
		webResource = client.resource("http://api.openweathermap.org/data/3.0/stations");
		response = webResource
				.queryParams(params)
				.accept("application/json")
				.type("application/json")
				.get(ClientResponse.class);
		System.out.println("Get PostCertificate:-  " + response);
		if (response.getStatus() == 500 || response.getStatus() == 409 || response.getStatus() == 404
				|| response.getStatus() == 403 || response.getStatus() == 401 || response.getStatus() == 400) {
			Assert.assertFalse(true, "api Getting response of:- " + response + "");
		}
		if (response.getStatus() == 200 || response.getStatus() == 201) {
			Assert.assertTrue(true, "api Getting response of:- " + response + "");
		}
		serviceresponse = response.getEntity(String.class);
		System.out.println(serviceresponse);
		String[] arr=serviceresponse.split(",");
		String[] id1=arr[0].split(":");
		 id=id1[1].replace('"',' ').trim();
		
	}
	
   @Test(priority = 4)
	public void test4() throws Exception {
	String serviceresponse;
	apikey="27e57ddee70cf1556662bce5a2184f30";
	String RESTFilePath = ap.xDownloadFiles("APIDelete");
	MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	params.add("appid",apikey);
		client = Client.create();
		webResource = client.resource("http://api.openweathermap.org/data/3.0/stations/"+id+"");
		response = webResource
				.queryParams(params)
				.accept("application/json")
				.type("application/json")
				.delete(ClientResponse.class);
		
		if (response.getStatus() == 500 || response.getStatus() == 404 || response.getStatus() == 403
				|| response.getStatus() == 401 || response.getStatus() == 400 || response.getStatus() == 409
				|| response.getStatus() == 200) {
			Assert.assertFalse(true, "API Getting response of:- " + response + "");
		}
		if (response.getStatus() == 204) {
			Assert.assertTrue(true, "API Getting response of:- " + response + "");
		}
		webResource = client
				.resource("http://api.openweathermap.org/data/3.0/stations/"+id+"");
		response = webResource
				.queryParams(params)
				.accept("application/json")
				.type("application/json")
				.delete(ClientResponse.class);
		if (response.getStatus() == 500 || response.getStatus() == 403
				|| response.getStatus() == 401 || response.getStatus() == 400 || response.getStatus() == 409
				|| response.getStatus() == 200 || response.getStatus() == 204) {
			Assert.assertFalse(true, "API Getting response of:- " + response + "");
		}
		if (response.getStatus()==404) {
			Assert.assertTrue(true, "API Getting response of:- " + response + "");
		}
		serviceresponse = response.getEntity(String.class);
		System.out.println(serviceresponse);
		
	}
}



