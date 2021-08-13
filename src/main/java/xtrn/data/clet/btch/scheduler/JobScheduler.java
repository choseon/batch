package xtrn.data.clet.btch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Slf4j
//@Component
//@RequiredArgsConstructor
public class JobScheduler {

//    private final Job job;
//    private final JobLauncher jobLauncher;

//    @Scheduled(fixedDelay = 3000) // 3초 간격
//    public void executeJob() {
//        try {
////            jobLauncher.run(
////                    job, new JobParametersBuilder().addString("cletDt", LocalDateTime.now().toString()).toJobParameters());
//            log.info("job >>> {}", job);
//            JobParameters jobParameters = new JobParametersBuilder().addString("cletDt", LocalDateTime.now().toString()).toJobParameters();
//            jobLauncher.run(job,jobParameters);
//        } catch (JobExecutionAlreadyRunningException e) {
//            e.printStackTrace();
//        } catch (JobRestartException e) {
//            e.printStackTrace();
//        } catch (JobInstanceAlreadyCompleteException e) {
//            e.printStackTrace();
//        } catch (JobParametersInvalidException e) {
//            e.printStackTrace();
//        }
//    }
}
