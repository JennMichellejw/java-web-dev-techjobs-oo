package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job test_job3;
    @Before
    public void createObject() {
         test_job1 = new Job();
         test_job2 = new Job();
         test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId(){
        assertFalse(test_job1.getId() == test_job2.getId());
        assertEquals(1, test_job2.getId() - test_job1.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", test_job3.getName());
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job3.getEmployer().toString());
        assertTrue(test_job3.getLocation() instanceof Location);
        assertEquals("Desert", test_job3.getLocation().toString());
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test_job3.getPositionType().toString());
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(test_job4, test_job3);

    }
// toString Tests
    @Test
    public void testToStringStartsAndEndsWithBlankLine(){
        assertTrue(test_job3.toString().substring(0,1).isBlank());
        assertTrue(test_job3.toString().substring(test_job3.toString().length()).isBlank());
    }

    @Test
    public void testToStringContainsLabelAndDataForEachField(){
        assertTrue(test_job3.toString().contains("\nID: " + test_job3.getId()));
        assertTrue(test_job3.toString().contains("\nName: " + test_job3.getName()));
        assertTrue(test_job3.toString().contains("\nEmployer: " + test_job3.getEmployer()));
        assertTrue(test_job3.toString().contains("\nLocation: " + test_job3.getLocation()));
        assertTrue(test_job3.toString().contains("\nPosition Type: " + test_job3.getPositionType()));
        assertTrue(test_job3.toString().contains("\nCore Competency: " + test_job3.getCoreCompetency()));

    }

    @Test
    public void testIfFieldEmptyPrintDataNotAvailable(){

        Job test_job5 = new Job("Product tester", new Employer("") , new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job5.toString().contains("\nEmployer: " + "Data not available"));

    }

    @Test
    public void testIfOnlyIdExistsReturnJobDoesNotExists(){
        assertEquals("OOPS! This job does not seem to exist.", test_job1.toString());
    }
    

}
