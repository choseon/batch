package xtrn.data.clet.btch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import xtrn.data.clet.btch.jobs.biz.biz001m.Biz001mTasklet;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableScheduling
@EnableBatchProcessing
public class BizJobConfiguration {

    @Value("${api.biz.url}")
    private String url;

    @Value("${api.biz.crtfcKey}")
    private String crtfcKey;

    @Value("${api.biz.dataType}")
    private String dataType;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final JobLauncher jobLauncher;

//    @Scheduled(cron = "* */2 * * * ?")
    public void perform() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addString("cletDt", LocalDateTime.now().toString()).toJobParameters();
        jobLauncher.run(bizJob(),jobParameters);
    }

    @Bean(name = "bizJob")
    public Job bizJob() {

        log.info("url >>> {}", this.url);
        log.info("ctrfcKey >>> {}", crtfcKey);
        log.info("dataType >>> {}", dataType);
        return jobBuilderFactory.get("bizJob").start(biz001Step()).build();
    }

    @Bean
    public Step biz001Step() {
        return stepBuilderFactory.get("biz001mStep").tasklet(new Biz001mTasklet()).build();
    }

}
