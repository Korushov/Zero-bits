package ru.korushov.zero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.korushov.zero.producer.FileProcessor;

/**
 * @author Vitaly Korushov
 */

@SpringBootApplication
public class Application {
    @Autowired
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws Exception {
        Application.run(args);
    }

    public static void run(String[] args) throws Exception {
        if (args.length != 0) {
            // Get the filename from command line arguments
            String filePath = args[0];

            // Produce file parts
            fileProcessor.produceFileParts(filePath);
        } else {
            System.out.println("Please provide the 'file' option with the filename as an argument.");
        }
    }
}
