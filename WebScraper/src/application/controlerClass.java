package application;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class controlerClass {

	@FXML
	private TextField job1;
	@FXML
	private TextField job2;
	@FXML
	private TextField job3;
	@FXML
	private TextField job4;
	@FXML
	private TextField job5;
	@FXML
	private Label result1;
	@FXML
	private Label result2;
	@FXML
	private Label result3;
	@FXML
	private Label result4;
	@FXML
	private Label result5;
	@FXML
	private Label jobname1;
	@FXML
	private Label jobname2;
	@FXML
	private Label jobname3;
	@FXML
	private Label jobname4;
	@FXML
	private Label jobname5;
	@FXML
	private Button search;

	

	public static String getJobResults(String s) {
		
		String html = "https://www.indeed.com/jobs?q="+ s;
		
		try {
			
			Document doc = Jsoup.connect(html).get();
			Element element = doc.select("#searchCountPages").first(); 
			String num_job=element.text();
			
			return cleanNumJobs(num_job);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
		}
		
		return "none found";
		
	}
	
	//cleaning the job result method so its all numbers
	public static String cleanNumJobs(String s) {
		
		String clean = s.replaceAll("Page 1 of ", "");
		String clean2 = clean.replaceAll(" jobs", "");
		//String clean3 = clean2.replaceAll(",", "");
		return clean2;
		
	}
	
	
	
	public void action(ActionEvent event) {
		// TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      
      //names of top 5 jobs youre looking 
      String job1n = job1.getText();
      String job2n = job2.getText();
      String job3n = job3.getText();
      String job4n = job4.getText();
      String job5n = job5.getText();
      
      //jobs numbers
      String job1;
      String job2;
      String job3;
      String job4;
      String job5;

      
      job1 = controlerClass.getJobResults(job1n);
      job2 = controlerClass.getJobResults(job2n);
      job3 = controlerClass.getJobResults(job3n);
      job4 = controlerClass.getJobResults(job4n);
      job5 = controlerClass.getJobResults(job5n);
      
      
//      jobname1.setText(job1n);
//      jobname2.setText(job2n);
//      jobname3.setText(job3n);
//      jobname4.setText(job4n);
//      jobname5.setText(job5n);
//     
      
      //output of number of jobs
      result1.setText(job1);
      result2.setText(job2);
      result3.setText(job3);
      result4.setText(job4);
      result5.setText(job5);
      
      
//     System.out.printf("The number of jobs available for the follwoing occupation:%n");
//      System.out.println(job1n+":"+job1);
//      System.out.println(job2n+":"+job2);
//      System.out.println(job3n+":"+job3);
//      System.out.println(job4n+":"+job4);
//      System.out.println(job5n+":"+job5);
      
	
	
	
	
}
}
