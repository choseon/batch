package xtrn.data.clet.btch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing // Spring Batch 기능 활성화
@SpringBootApplication
@EnableScheduling
public class EdcBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdcBatchApplication.class, args);
    }

}
