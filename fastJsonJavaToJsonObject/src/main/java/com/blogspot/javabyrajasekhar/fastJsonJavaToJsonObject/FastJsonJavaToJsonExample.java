package com.blogspot.javabyrajasekhar.fastJsonJavaToJsonObject;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class FastJsonJavaToJsonExample {

    public static void main(String[] args) {

        Staff staff = createStaff();

        // Java objects to JSON
        String json = JSON.toJSONString(staff);
        System.out.println(json);

        // Java objects to JSON, pretty-print
        String json2 = JSON.toJSONString(staff, true);
        System.out.println(json2);

        // Java objects to JSON, with formatted date
        String json3 = JSON.toJSONStringWithDateFormat(staff, "dd/MM/yyyy HH:mm:ss");
        System.out.println(json3);

        // List of Java objects to JSON Array
        List<Staff> list = Arrays.asList(createStaff(), createStaff());
        String json4 = JSON.toJSONStringWithDateFormat(list, "dd/MM/yyyy HH:mm:ss");
        System.out.println(json4);

        try {
            // can't find fastjson api to write files, np, just use the standard java.nio Files.write
            Files.write(Paths.get("d:\\staff.json"), json4.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("rajasekhar");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        Map<String, BigDecimal> salary = new HashMap<String, BigDecimal>() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));
       // staff.setJoinDate(new Date());

        return staff;

    }

}