package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.junit.Assert.*;

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
        Job longTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", longTestJob.getName());
        assertTrue(longTestJob instanceof Job);
        assertEquals("ACME", longTestJob.getEmployer().getValue());
        assertTrue(longTestJob.getEmployer() instanceof Employer);
        assertEquals("Desert", longTestJob.getLocation().getValue());
        assertTrue(longTestJob.getLocation() instanceof Location);
        assertEquals("Quality Control", longTestJob.getPositionType().getValue());
        assertTrue(longTestJob.getPositionType() instanceof PositionType);
        assertEquals("Persistence", longTestJob.getCoreCompetency().getValue());
        assertTrue(longTestJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Pro Gamer", new Employer(""), new Location("Saint Louis"), new PositionType("Team Captain"), new CoreCompetency("Strategic"));
        Job testJob2 = new Job("Pro Gamer", new Employer("Esports Team"), new Location("Saint Louis"), new PositionType("Team Captain"), new CoreCompetency("Strategic"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Pro Gamer", new Employer("Esports Team"), new Location("Saint Louis"), new PositionType("Team Captain"), new CoreCompetency("Strategic"));
        assertTrue(testJob.toString().startsWith(System.lineSeparator()));
        assertTrue(testJob.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Pro Gamer", new Employer("Esports Team"), new Location("Saint Louis"), new PositionType("Team Captain"), new CoreCompetency("Strategic"));
        String sameString = System.lineSeparator() + "ID: " + testJob.getId() + System.lineSeparator() + "Name: " + testJob.getName() + System.lineSeparator() + "Employer: " + "Esports Team" + System.lineSeparator() + "Location: " + testJob.getLocation().getValue() + System.lineSeparator() + "Position Type: " + "Team Captain" + System.lineSeparator() + "Core Competency: " + testJob.getCoreCompetency().getValue() + System.lineSeparator();
        System.out.println(testJob);
        System.out.println(sameString);
        assertTrue(testJob.toString().equals(sameString));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Pro Gamer", new Employer(""), new Location("Saint Louis"), new PositionType(""), new CoreCompetency("Strategic"));
        String sameString = System.lineSeparator() + "ID: " + testJob.getId() + System.lineSeparator() + "Name: " + testJob.getName() + System.lineSeparator() + "Employer: " + "Data not available" + System.lineSeparator() + "Location: " + testJob.getLocation().getValue() + System.lineSeparator() + "Position Type: " + "Data not available" + System.lineSeparator() + "Core Competency: " + testJob.getCoreCompetency().getValue() + System.lineSeparator();
        System.out.println(testJob);
        System.out.println(sameString);
        assertTrue(testJob.toString().equals(sameString));
    }

}
