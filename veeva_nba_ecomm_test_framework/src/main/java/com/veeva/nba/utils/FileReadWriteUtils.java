package com.veeva.nba.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileReadWriteUtils {

    public static String readDataFromPropertiesFile(String filePath,String key){
        String dataValue;
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Properties properties = new Properties();
            properties.load(fileInputStream);
            dataValue = properties.get(key).toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Issue while reading data form Properties file");
        }
        return dataValue;
    }
}
