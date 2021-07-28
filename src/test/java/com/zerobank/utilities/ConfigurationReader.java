package com.zerobank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
   // we will creat reusable method that will be reading from configuration reader file

   //1) creat properties object
   private static Properties properties = new Properties();

   //2.creat static block because i can not print any thing in order to print i shoule creat a block
   // another reason because static block run before everything elas
   static{

      try {
         //#2.load the file into fileInputStream
         FileInputStream file = new FileInputStream("configuration.properties");

         //#3.load properties object with the file ("configuration.properties")
         properties.load(file);
      } catch (IOException e) {
         System.out.println("file not found in configuration properties");
      }


   }
   //Use the above created logic to creat A re-usable static method use object in line 22
   public static String getProperty(String keyWord){
      return properties.getProperty(keyWord);

}}