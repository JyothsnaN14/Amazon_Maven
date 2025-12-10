package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Logic implements ITestListener {
public static ChromeDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		TakesScreenshot ts=driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\Screenshots\\pass\\"+new Listener_Logic().getClass()+"_"+Math.random()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}}
	

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts=driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Uday\\eclipse-workspace\\Amazon_MavenProject1\\Screenshots\\fail\\"+new Listener_Logic().getClass()+"_"+Math.random()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
