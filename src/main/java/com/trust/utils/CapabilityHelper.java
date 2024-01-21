package com.trust.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CapabilityHelper {
    public static Map<String, String> getCapabilitiesMap(String filename) throws IOException {
        Properties props = PropertyHelper.loadProperties(filename);
        Map<String, String> map = (Map) props;
        String path = map.get("app");
        File appPath = new File(path);
        map.put("app", appPath.getAbsolutePath());
        return map;
    }
}
