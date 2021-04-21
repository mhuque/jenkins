package Utilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import ups.nj.supperpage.CucumberBaseClass;

public class CommonUtility extends CucumberBaseClass {

	public static void jsClick(WebElement elm) {
		JavascriptExecutor excuter = (JavascriptExecutor) driver;
		excuter.executeScript("arguments[0].click();", elm);
	}

	public static void acctionClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).build().perform();

	}

	public static WebElement getExplicitWait(WebElement elem, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;

	}
	
	public static void takeScreenShot() throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "//screenshot/screenshot.png");
		targetFile.getParentFile().mkdir();
		srcFile.createNewFile();
		Files.copy(srcFile, targetFile);
		
		
		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String time = timeStamp + ".png";
//		
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir") + "//screenshot/screenshot-" + time);
//		targetFile.getParentFile().mkdir();
//		srcFile.createNewFile();
//		Files.copy(srcFile, targetFile);
		
	}
	
public void getHighLighter(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 4px solid red;');", element);		
	}	

}