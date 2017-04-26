package practicet1;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver = null;
	private  FirefoxProfile firefoxProfile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	public  Browsers(BrowsersType browserstype){
		switch(browserstype) {
		case firefox:
//			System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");			
//			File firebug = new File(projectpath+"\\tool\\firebug@software.joehewitt.com.xpi");
//			File firepath = new File(projectpath+"\\tool\\FireXPath@pierre.tholence.com.xpi");
			firefoxProfile = new FirefoxProfile();
			try {
//				firefoxProfile.addExtension(firebug);
//				firefoxProfile.addExtension(firepath);
				firefoxProfile.setPreference("webdriver.accept.untrusted.certs", "true");
				firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				firefoxProfile.setPreference("network.proxy.type", 0);
				firefoxProfile.setPreference("network.proxy.http", "10.1.1.0");
				firefoxProfile.setPreference("network.proxy.http_port", 3128);
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver = new FirefoxDriver(firefoxProfile);
			break;
		case ie:	
			System.setProperty("webdriver.ie.driver", projectpath+"\\tool\\IEDriverServer.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);			
			break;
		case chrome:	
			System.setProperty("webdriver.chrome.driver", projectpath+"\\tool\\chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));//最大化浏览器
			driver = new ChromeDriver(caps);			
			break;
	}
}
}
