package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
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

        // You can create Jobparameters for the JobExecution
        JobParameters params = new JobParametersBuilder().addString("param1", "value1").toJobParameters();
        
        // launches the job with the input file /src/test/resources/data.csv
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(params);

        // How to check for the Job Status
        Assertions.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());

        // Job should have inserted 4 Customers
        Assertions.assertEquals(customerRepository.findAll().size(), 4);
    }

    
}
