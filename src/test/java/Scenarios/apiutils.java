package Scenarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class apiutils {
	public static String Value;

	//read json
public String xReadJSON(String JSONfilepath, String ObjectName, String dwnldfileid) throws Exception {
			JSONParser parser = new JSONParser();

		JSONParser parser1 = new JSONParser();
		 Value = null;
		try {
			Object obj = parser1.parse(new FileReader(JSONfilepath));
			JSONObject jsonObject = (JSONObject) obj;
			switch (ObjectName) {
			case "message":
				JSONObject data3 = (JSONObject) jsonObject.get("data");
				JSONObject status3 = (JSONObject) data3.get("status");
				Value = status3.get(ObjectName).toString();
				System.out.println(Value);
				break;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dwnldfileid;
		}
		
public static String xDownloadFiles(String FolderName) throws Exception {
					String DownloadFiles = null;
					File directory = new File(".//");
					String DownloadLoc = directory.getCanonicalPath();
					DownloadFiles = DownloadLoc + "\\" + "DownloadingFiles" + "\\" + FolderName;
					File CreateFolder = new File(DownloadFiles);
					if (!CreateFolder.exists()) {
						CreateFolder.mkdirs();
					}

					return (DownloadFiles);
				}
				
				
public void writeJsonFile(String jsonRespose, String FolderName, String filename) {
					try {

						File directory = new File(FolderName);
						File file = new File(directory.getCanonicalPath() + "\\" + filename);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(jsonRespose);
						bw.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
}
