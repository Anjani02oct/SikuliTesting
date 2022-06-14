package T;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		  //tt();
		  CompareCmd compare = new CompareCmd();
		  compare.setErrorConsumer(StandardStream.STDERR);
		  IMOperation cmpOp = new IMOperation();
		  // Set the compare metric
		  cmpOp.metric("mae");
		  // Add the expected image
		  cmpOp.addImage("D:/Box1.png");
		  // Add the current image
		  cmpOp.addImage("D:/Box1.png");
		  // This stores the difference
		  cmpOp.addImage("D:/difference.png");
		  try {
		    // Do the compare
			 compare.run(cmpOp);
		    //System.out.println(compare.run(cmpOp));
		    //return true;
			 System.out.println("True");
		  }
		  catch (Exception ex) {
		    //return false;
			  System.out.println("False");
			  //ex.printStackTrace();
		  }

	}
	
	public static void tt() throws InterruptedException, AWTException
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ananya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//Selenium ChromeDriver object is created, it will open the chrome browser window
		driver = new ChromeDriver();
		//maximize the browser window
		driver.manage().window().maximize();
		driver.get("https://devtoolzone.com/decompiler/java");
		//Added implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Added to wait till page gets loaded completely
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		String sPath = "C:\\Users\\Ananya\\Downloads\\im4java-1.4.0 - Copy (extract.me)\\org\\im4java\\utils";
		File directoryPath = new File(sPath);
	    String contents[] = directoryPath.list();
	    System.out.println("List of files and directories in the specified directory:");
	    for(int i=0; i<contents.length; i++) 
	    {
	    	String sFilename = contents[i];
	        System.out.println(sFilename);
	        System.out.println(sPath + "\\" + sFilename);
			StringSelection selection = new StringSelection(sPath + "\\" + sFilename);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			driver.findElement(By.id("subfile")).click();
			Thread.sleep(2000);
			Robot r = new Robot();
		    r.keyPress(KeyEvent.VK_CONTROL);
		    r.keyPress(KeyEvent.VK_V);
		    r.keyRelease(KeyEvent.VK_CONTROL);
		    r.keyRelease(KeyEvent.VK_V);
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(2000);
			driver.findElement(By.id("decompile")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='downloadBtn']/a/span")).click();
			Thread.sleep(5000);
	    }
	    
	}
	
	
	
	

}
