package com.qa.util;



import java.io.File;

public class Constants {
    //[id="pega_ui_load"] loader
    private static final String BASE_PATH = System.getProperty("user.dir");
    private static final String RESOURCES_PATH = BASE_PATH + "/src/test/resources/";
    private static final String CONFIG_FILE_PATH = BASE_PATH + "/src/test/resources/config/config.properties";
    private static final String EXTENT_CONFIG_FILE_PATH = BASE_PATH + "extent-config.xml";
    public static final String TEST_DATA_FILE_PATH = RESOURCES_PATH + "automatonData.xlsx";
  

    public static String getResourcesPath() {
        return RESOURCES_PATH;
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

   
    
    
    public static String getExtentConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

}
