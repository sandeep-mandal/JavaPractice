package packageMultithreadingExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Multithreading extends Thread {

	private Thread t;
	private String threadName;

	public Multithreading(String searchtext) {
		threadName = searchtext;
		System.out.println("Creating thread for " + threadName);
	}

	public void run() {
		System.out.println("Running thread for " + threadName);
		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Workspaces\\Practice\\Java\\drivers\\chromedriver-2.38.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");

			WebDriver driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();

			SeleniumWikipedia wiki = new SeleniumWikipedia(driver);
			wiki.Search(threadName);

			driver.close();
			driver.quit();

			// Let the thread sleep for a while.
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting thread for " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}

	}

}
