package com.blogspot.javabyrajasekhar.fastJsonJsonToJavaObject;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FastJsonJsonToJavaExample {

    public static void main(String[] args) {

        // JSON string to Java object
        String jsonString = "{\"age\":38,\"name\":\"rajasekhar\"}";
        Staff staff = JSON.parseObject(jsonString, Staff.class);

        System.out.println(staff);

        // JSON array to Java object
        String jsonArray = "[{\"age\":38,\"name\":\"rajasekhar\"}, {\"age\":39,\"name\":\"rajasekhar\"}]";
        List<Staff> staff1 = JSON.parseArray(jsonArray, Staff.class);

        System.out.println(staff1);

        // JSON array in File to Java object
        // staff.json contain JSON array
        try (Stream<String> lines = Files.lines(Paths.get("d:\\staff.json"))) {

            String content = lines.collect(Collectors.joining());
			// Hope parseArray() will support File or Reader in future.
            List<Staff> list = JSON.parseArray(content, Staff.class);
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}