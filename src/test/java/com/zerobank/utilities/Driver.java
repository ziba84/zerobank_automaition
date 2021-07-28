package com.zerobank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    // creating  privat constructor so this classes object is not reachable from outside

    private Driver(){
    }

    /*
    Making our driver instance private so that is not reachable from outside of the class
    we make it static ,to use the method come with static and also because
    we want it to run before everything else,and also we will use it in a static method
     */
    private static ThreadLocal<WebDriver> driverPool=new ThreadLocal<>();// when we dont assign any thing is null by default

    // creat reusable method that will return same 'driver' instance everytime we call it

    public static WebDriver getDriver(){
        if(driverPool.get()==null) {
            synchronized ((Driver.class)) {




            /*
            we read our browser type from configuration file using .getProperty method we
            creating in configuration Reader class.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */

            // we use this not testBase we use this test base just for practice
            switch (browserType) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;

            }
        }

        }
        /*
        Same driver instance will be return every time we call Driver.getDriver(); method
         */
        return driverPool.get();
    }

    /*
    this method makes sure we have some form of driver session or driver id has.
    either null or not null it must exit
     */
    public static void closeDriver(){
        if(driverPool.get()!=null){//to be able to creat our good flow,when we use driver quit session will killed if driver is not there
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
