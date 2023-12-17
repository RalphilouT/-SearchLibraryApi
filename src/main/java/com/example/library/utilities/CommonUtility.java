package com.example.library.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtility {
    InputStream inputStream;
    Properties properties = new Properties();
    public Properties getApiKey() throws IOException{
        try {
            String propFileName = "application.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream != null){
                properties.load(inputStream);
            }else {
                throw new FileNotFoundException("property file '" + propFileName +"' not found in the classpath");

            }
        }catch (Exception e){
            System.out.println("Exception: " + e);

        }finally {
            inputStream.close();
        }
        return properties;
    }
}
