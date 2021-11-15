package org.springframework.samples.petclinic.util;
import java.io.FileWriter;

public class FileUtility {
    void generateReport(String content) throws Exception {
        FileWriter fwriter = new FileWriter("~/Downloads/report.csv");
        fwriter.write(content);
        fwriter.close();
    }
}
