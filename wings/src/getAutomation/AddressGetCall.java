/*package getAutomation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.ReportActionKeys;
import io.restassured.response.Response;
import waste.DataDrivenFor;

import static com.jayway.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddressGetCall{
	public static String keyFromExcel=null;
	public static	String dataFromPS=null;
	public static	String datafromDB=null;
		
		public static String  getDb(String query) throws  ClassNotFoundException, SQLException {	
			String myName=null;
			try{String dbUrl = "jdbc:postgresql://192.168.0.32/Base_4.8.0";					
			String username = "postgres";	
				String password = "password";	
				
			String query1 =query;// "select acc_no  from dep_mast where acc_no  like'002%' and prd_id=278 order by acc_no desc limit 1";	
			Class.forName("org.postgresql.Driver");			
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			Statement stmt = con.createStatement();					
			ResultSet rs= stmt.executeQuery(query1);
			
			while (rs.next()){
				System.out.println(query1);
			    		 myName = rs.getString(1);
			    		 
			    		
			           	System.out.println("************");
			            System. out.println(myName+"     data from DB  ");		
			    }	
			con.close();			

				return myName; 	
			}
			catch(Exception e){
e.printStackTrace();
			}
			return myName;}
		@BeforeTest
		public void startReport(){
			ReportActionKeys.setReportLocation("C:\\Report\\wingsGetAPI.html");
			ReportActionKeys.appendToExstingReport("C:\\Report\\wingsGetAPI.html");
			ReportActionKeys.startTest("CustomerId");
		}
	
	@Test (dataProvider="accountinfo")
	public void getRequestFindCapital(String instructionId,String instructionIdDb) throws JSONException {
		
	try{	String APIUrl="http://localhost:9090/API/iris/v1/iris/address/addressInfo?custId=DS0000000068&type=A";
		Response response =given().authentication().preemptive().basic("", "").get(APIUrl);
		String resp=response.asString();
		System.out.println(resp);
		JSONObject JSONResponseBody = new JSONObject(resp);
		keyFromExcel=instructionId.trim();
dataFromPS = JSONResponseBody.getString(keyFromExcel);
		
		System.out.println(keyFromExcel+"  data from ps--->"+keyFromExcel+"--->"+dataFromPS);
		
		
			datafromDB=getDb(instructionIdDb);
				System.out.println(keyFromExcel+"   data from db--->"+keyFromExcel+"--->"+datafromDB);
			 
				
			
			//ReportActionKeys.startTest(keyFromExcel+"  Testing");
			ReportActionKeys.writeLogInfo("ActualData of  "+keyFromExcel+" ::"+datafromDB);
			ReportActionKeys.writeLogInfo("DataFrom ps of  "+keyFromExcel+" :: "+dataFromPS);
			
			System.out.println(datafromDB);
			
			if(dataFromPS.equals(datafromDB)){
				
			ReportActionKeys.writeLogInCaseOfPass(keyFromExcel+" ::"+datafromDB+" == "+keyFromExcel+" :: "+dataFromPS+"Instruction  Sucessfully fetched");
			
				
			}
			else{ReportActionKeys.writeLogInCaseOfFail("ActualData of  "+keyFromExcel+" ::"+datafromDB+  "DataFrom ps of  "+keyFromExcel+" :: "+dataFromPS+"    DATA NOT MATCHED WITH DATABASe");
				
			}
			}
		
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				ReportActionKeys.writeLogInCaseOfFail("ActualData of  "+keyFromExcel+" ::"+datafromDB+  "DataFrom ps of  "+keyFromExcel+" :: "+dataFromPS+"  Exception");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ReportActionKeys.writeLogInCaseOfFail("ActualData of  "+keyFromExcel+" ::"+datafromDB+  "DataFrom ps of  "+keyFromExcel+" :: "+dataFromPS+"  Exception");
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			ReportActionKeys.writeLogInfo("ActualData of  "+keyFromExcel+" ::"+datafromDB+  "DataFrom ps of  "+keyFromExcel+" :: "+dataFromPS+"  JSONException");
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			ReportActionKeys.writeLogInCaseOfFail("ActualData of  "+keyFromExcel+" fetching null");
		}
		
	}
	@DataProvider(name="accountinfo")
	public Object[][] postData(){
		return DataDrivenFor.data("C://Users//sgarlapati//Desktop//testingPostman.xls","Sheet2");
	}
	@AfterMethod
	public void writeReport(){
		ReportActionKeys.endTest();
		ReportActionKeys.writeLogToReport();
	}
}*/