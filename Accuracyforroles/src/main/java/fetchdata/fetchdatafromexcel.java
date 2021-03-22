package fetchdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;

public class fetchdatafromexcel
{
	
	public void loadKeywordMaster() throws Exception
	{
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  		
			Connection connection=DriverManager.getConnection("jdbc:mysql://jmdb-predictor-dev.cptvjl3vuwqy.ap-south-1.rds.amazonaws.com/role_predictor_dev","jmlabsuser","Testpass10");
			Statement statement=connection.createStatement(); //Creating a Statement to execute the query 
			ResultSet queryResult= null;
			if(rolePrediction.get("industry") != null && !rolePrediction.get("industry").toString().isEmpty() )
			{
		    	//System.out.println("select * from `Keyword_UAT` where `active`=1 and `Industry` = `"+rolePrediction.get("industry").toString()+"`");
			    queryResult=statement.executeQuery("select * from `Keyword_UAT` where `active`=1 and lower(`Industry`) in (\""+rolePrediction.get("industry").toString()+"\")");//Getting th result set for the query 
			}
			else
			{
		    	queryResult=statement.executeQuery("select * from `Keyword_UAT` where `active`=1");//Getting th result set for the query 
			}
		}
	}
}