package com.trust.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {

    public static Properties loadProperties(String filename) throws IOException {
        Properties props = new Properties();
        FileReader reader = new FileReader(filename);
        props.load(reader);
        return props;
    }
}
