package xtrn.data.clet.btch.scheduler;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xtrn.data.clet.btch.jobs.big.big001m.Big001mTasklet;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BigJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final JobLauncher jobLauncher;

//    @Scheduled(cron = "*/5 * * * * ?") // 5초마다
//    @Scheduled(fixedDelay = 10000) // 10초
    public void perform() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addString("cletDt", LocalDateTime.now().toString()).toJobParameters();
        jobLauncher.run(bigJob(),jobParameters);
    }

    @Bean(name = "bigJob")
    public Job bigJob() {
        return jobBuilderFactory.get("bigJob").start(big001mStep()).build();
    }

    @Bean
    public Step big001mStep() {

        return stepBuilderFactory.get("big001mStep").tasklet(new Big001mTasklet()).build();
    }
}
