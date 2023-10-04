package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBatchTest
@SpringBootTest
public class BatchEnd2EndTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void testJob(@Autowired Job job) throws Exception {
        this.jobLauncherTestUtils.setJob(job);

        JobExecution jobExecution = jobLauncherTestUtils.launchJob();


        Assertions.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
    }

    
}
