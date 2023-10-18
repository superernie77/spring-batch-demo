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

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Example how to test a Spring Batch Job with the JobLauncherTestUtils.
     * For this to work, you need to disable that Spring Boot starts the Job automatically on startup.
     * Check src/test/resource/application.properties how to disable this.
     */
    @Test
    public void testJob(@Autowired Job job) throws Exception {
        this.jobLauncherTestUtils.setJob(job);

        // launches the job with the input file in /src/test/resources/data.csv
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assertions.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());

        // job should have inserted 4 customer
        Assertions.assertEquals(customerRepository.findAll().size(), 4);



        

    }

    
}
