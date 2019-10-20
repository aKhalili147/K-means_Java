package kmeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {
  
  /**
   * It's better to use dedicated libraries such as OpenCSV.
   * In the meantime, just make sure there's no other lines than data lines
   * (no header, no blank lines and so on)
   */
  public static ArrayList<ArrayList<String>> importCSV(String filename, String separator) {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    String line = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      while ((line = br.readLine()) != null){
        ArrayList<String> dataAsString = new ArrayList<String>(Arrays.asList(line.split(separator)));
        data.add(dataAsString);
      }
      br.close();
    }catch(IOException e) {e.printStackTrace();}
    return data;
  }
  
  public static void exportDataToCSV(String filename, String data) {
    try {
      Writer out = new BufferedWriter(new FileWriter(filename));
      out.write(data);
      out.close();
    } catch (IOException e) { e.printStackTrace(); }
  }
  
}
