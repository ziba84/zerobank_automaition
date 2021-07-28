package com.zerobank.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class browserUtils {


    public static void assertTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }



    /**
    this method accept List<webElement> and return as List<String>
     @param webElementList
     */

    public static List<String> getElementText(List<WebElement> webElementList){

        // creat place holder list of String
        List<String> actualAsString=new ArrayList<>();
        for (WebElement each:webElementList) {
            actualAsString.add(each.getText());

        }
        return actualAsString;
    }

    //putting our reusable method
    /**
     * Method that will accept int argument
     * waite for given second duration
     */
    public static void sleep(int second)  {// because it will accept milli second
        second*=1000;
        // 1sec=1000 milli seconds
        // 1*1000=1000

        try {
            Thread.sleep(second);// second way to handle thread.sleep
        } catch (InterruptedException e) {
            System.out.println("something happened in thread.sleep");
        }


    }

}
