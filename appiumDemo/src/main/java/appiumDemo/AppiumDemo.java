package appiumDemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumDemo {
	private final static String appiumUri = "http://127.0.0.1:4723/";

	public AppiumDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		AndroidDriver driver = null;
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("appium:platformVersion", "15.0");
		options.setCapability("appium:udid", "R123ABC123A");
		options.setCapability("platformName", "Android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("noReset", "true");
		options.setCapability("fullReset", "false");
		options.setCapability("dontStopAppOnReset", "true");
		try { 
			driver = new AndroidDriver(
					new URI(appiumUri).toURL(), 
					options);
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Menu, idle 5s, Home
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
