package com.example.demo;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
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
public class SingleStepTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Tests a single Step of a Job
	 * @param job
	 * @throws Exception
	 */
	@Test
	public void testStep() throws Exception {
		
		// You can create Jobparameters for the JobExecution
		JobParameters params = new JobParametersBuilder().addString("param1", "value1").toJobParameters();

		JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1", params);
		ExitStatus actualJobExitStatus = jobExecution.getExitStatus();

		// How to check for the Job Status
		Assertions.assertEquals("COMPLETED", actualJobExitStatus.getExitCode());

		// Job should have inserted 4 Customers
		Assertions.assertEquals(customerRepository.findAll().size(), 4);
	}

}
