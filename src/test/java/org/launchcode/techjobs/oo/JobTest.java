package org.launchcode.techjobs.oo;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(), "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(), "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        byte[] testJobtoStringBytes = testJob.toString().getBytes();
        byte[] lineSeparatorBytes = System.lineSeparator().getBytes();

        assertEquals(lineSeparatorBytes[0], testJobtoStringBytes[0]);
        assertEquals(lineSeparatorBytes[1], testJobtoStringBytes[1]);
        assertEquals(lineSeparatorBytes[0], testJobtoStringBytes[testJobtoStringBytes.length-2]);
        assertEquals(lineSeparatorBytes[1], testJobtoStringBytes[testJobtoStringBytes.length-1]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = System.lineSeparator() +
                            "ID: " + testJob.getId() + System.lineSeparator() +
                            "Name: " + testJob.getName() + System.lineSeparator() +
                            "Employer: " + testJob.getEmployer().getValue() + System.lineSeparator() +
                            "Location: " + testJob.getLocation().getValue() + System.lineSeparator() +
                            "Position Type: " + testJob.getPositionType().getValue() + System.lineSeparator() +
                            "Core Competency: " + testJob.getCoreCompetency().getValue() +
                            System.lineSeparator();

        assertEquals(testString, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", null, new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = System.lineSeparator() +
                "ID: " + testJob.getId() + System.lineSeparator() +
                "Name: " + testJob.getName() + System.lineSeparator() +
                "Employer: " + "Data not available" + System.lineSeparator() +
                "Location: " + "Data not available" + System.lineSeparator() +
                "Position Type: " + testJob.getPositionType().getValue() + System.lineSeparator() +
                "Core Competency: " + testJob.getCoreCompetency().getValue() +
                System.lineSeparator();

        assertEquals(testString, testJob.toString());

    }



}
