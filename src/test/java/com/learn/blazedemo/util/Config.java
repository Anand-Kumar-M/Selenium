package com.learn.blazedemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties; 

//Config class to get any config set in the properties file
public class Config {
    private URL urlclassResourcePath;
    
    //to get resource url
    public static URL getResourcePath(Class classObj, String strResourceRelativePath){
        URL uriPath;
        try{
            uriPath = classObj.getClassLoader().getResource(strResourceRelativePath.replace("//","/"));
        }catch (Exception e){
            e.printStackTrace();
            uriPath =  null;
        }
        return uriPath;
    }
    

    public static String getPropertyValue(URL urlPath,String strPropertyKey){
        Properties prop = new Properties();
        String strPropertyValue = null;
        try(InputStream inputStream = new FileInputStream(new File(urlPath.toURI()))){
            prop.load(inputStream);
            strPropertyValue =  prop.getProperty(strPropertyKey,null);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return strPropertyValue;
    }
    
    public String getValue(String strPropertyKey){
        return Config.getPropertyValue(urlclassResourcePath,strPropertyKey);
    }
    public void setResourcePath(Class classObj, String strResourceRelativePath){
        urlclassResourcePath = Config.getResourcePath(classObj,strResourceRelativePath);
    }
}
