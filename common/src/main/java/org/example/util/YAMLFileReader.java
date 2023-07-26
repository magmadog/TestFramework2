package org.example.util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YAMLFileReader {

    protected static List<Map<String, String>> data;

    public static void load(InputStream inputStream) {
        var yaml = new Yaml();
        data = yaml.load(inputStream);
    }
}
