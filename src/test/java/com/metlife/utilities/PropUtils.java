package com.metlife.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

    public static String getValue(String key) throws IOException {
        FileInputStream file=new FileInputStream("test-data/data.properties");
        Properties prop=new Properties();
        prop.load(file);
        String value=prop.getProperty(key);

        //run always  //run always - put it in finally block
        file.close();

        return value;
    }
}
