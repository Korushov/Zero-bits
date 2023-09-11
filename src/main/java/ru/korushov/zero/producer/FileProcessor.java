package ru.korushov.zero.producer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Vitaly Korushov
 */

@Component
public class FileProcessor {
    private KafkaTemplate<String, String> kafkaTemplate;
    private long fileParts;

    @Autowired
    public FileProcessor(KafkaTemplate<String, String> kafkaTemplate,
                         @Value("config.file-parts") long fileParts) {
        this.kafkaTemplate = kafkaTemplate;
        this.fileParts = fileParts;
    }

    public void produceFileParts(String filePath) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);

    }
}
