package com.cake.springbootvelocity;

import com.cake.springbootvelocity.service.TemplateService;
import com.cake.springbootvelocity.service.impl.TemplateServiceImpl;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateServiceImplTest {

	@Test
	void testProcessTemplate_Success() throws IOException, TemplateException {
		String expectedOutput = "Hello John! Welcome to MadMobile Loyalty.";

		// Create an instance of the class that contains the process() method
		// Replace MyClass with the actual class name
		TemplateService templateService = new TemplateServiceImpl();

		// Call the process() method
		String actualOutput = templateService.process();

		// Compare the actual output with the expected output
		assertEquals(expectedOutput, actualOutput);
	}


	@Test
	void testProcessTemplate_Performance() throws IOException, TemplateException {
		TemplateService templateService = new TemplateServiceImpl(); // Instantiate your TemplateService

		int numIterations = 100000;

		long startTime = System.nanoTime();
		for (int i = 0; i < numIterations; i++) {
			try {
				String result = templateService.process();
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
			}
		}

		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / 1e9;

		System.out.println("Time taken for " + numIterations + ": " + duration + " seconds");
	}
}
