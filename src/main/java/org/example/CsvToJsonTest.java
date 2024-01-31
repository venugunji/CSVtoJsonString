package org.example;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import com.google.gson.GsonBuilder;

public class CsvToJsonTest {
    public static void main(String args[]) throws Exception {
        File input = new File("/Users/venu/Desktop/democsv.csv");
        try {

            //CSV to Java Collection
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<?, ?>> list = mappingIterator.readAll();


            //Java Collection to Json String
            String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                    create().toJson(list);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}