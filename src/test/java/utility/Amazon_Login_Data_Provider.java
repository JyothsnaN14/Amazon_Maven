package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;

public class Amazon_Login_Data_Provider {
	@DataProvider()
	public Object[][] AmazonloginData_CorrectCredentials() throws EncryptedDocumentException, IOException{
		
	FileInputStream f1=new FileInputStream("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\DDT\\Amazon_LoginDetails.xlsx");
	Workbook w1=WorkbookFactory.create(f1);
	Object[][] data=new Object[1][2];
	//Correct_Username
	data[0][0]=NumberToTextConverter.toText(w1.getSheet("Login_Credentials").getRow(1).getCell(0).getNumericCellValue());
	
	//Correct_pwd
	data[0][1]=w1.getSheet("Login_Credentials").getRow(1).getCell(1).getStringCellValue();
	 return data;
	}
	@DataProvider()
	public Object[][] AmazonloginData_InCorrectCredentials() throws EncryptedDocumentException, IOException{
		
	FileInputStream f1=new FileInputStream("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\DDT\\Amazon_LoginDetails.xlsx");
	Workbook w1=WorkbookFactory.create(f1);
	Object[][] data=new Object[1][2];
	//InCorrect_Username
	data[0][0]=NumberToTextConverter.toText(w1.getSheet("Incorrect_Credentials").getRow(1).getCell(0).getNumericCellValue());
	
	//InCorrect_pwd
	data[0][1]=w1.getSheet("Incorrect_Credentials").getRow(1).getCell(1).getStringCellValue();
	 return data;
	}
	@DataProvider()
	public Object[][] AmazonloginData_User2CorrectCredentials() throws EncryptedDocumentException, IOException{
		
	FileInputStream f1=new FileInputStream("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\DDT\\Amazon_LoginDetails.xlsx");
	Workbook w1=WorkbookFactory.create(f1);
	Object[][] data=new Object[1][2];
	//User2Correct_Username
	data[0][0]=NumberToTextConverter.toText(w1.getSheet("Login_Credentials").getRow(2).getCell(0).getNumericCellValue());
	
	//User2Correct_pwd
	data[0][1]=w1.getSheet("Login_Credentials").getRow(2).getCell(1).getStringCellValue();
	 return data;
	}
	@DataProvider()
	public Object[][] AmazonloginData_NewUserCredentials() throws EncryptedDocumentException, IOException{
		
	FileInputStream f1=new FileInputStream("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\DDT\\Amazon_LoginDetails.xlsx");
	Workbook w1=WorkbookFactory.create(f1);
	Object[][] data=new Object[1][3];
	//NewUser_Username
	data[0][0]=NumberToTextConverter.toText(w1.getSheet("New_User").getRow(1).getCell(0).getNumericCellValue());
	//Customer name
	data[0][1]=w1.getSheet("New_User").getRow(1).getCell(1).getStringCellValue();
	//password
	data[0][2]=w1.getSheet("New_User").getRow(1).getCell(2).getStringCellValue();
	return data;

	}	
	
}
