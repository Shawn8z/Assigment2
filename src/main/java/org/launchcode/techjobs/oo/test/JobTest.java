package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        String str = "Id matched,  somethings wrong.";
        assertNotEquals(str, job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job obj = new Job("Product tester", new Employer("ACEM"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertTrue(obj.getName() instanceof String);
        assertEquals(obj.getName(), "Product tester");

        assertTrue(obj.getEmployer() instanceof Employer);
        assertEquals(obj.getEmployer().getValue(), "ACEM");

        assertTrue(obj.getLocation() instanceof Location);
        assertEquals(obj.getLocation().getValue(), "Desert");

        assertTrue(obj.getPositionType() instanceof PositionType);
        assertEquals(obj.getPositionType().getValue(), "Quality control");

        assertTrue(obj.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(obj.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("str", new Employer("ABC"), new Location("Street"),
                new PositionType("intern"), new CoreCompetency("Persistence"));

        Job job2 = new Job("str", new Employer("ABC"), new Location("Street"),
                new PositionType("intern"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job obj = new Job("str", new Employer("ABC"), new Location("Street"),
                new PositionType("intern"), new CoreCompetency("Persistence"));

        int strLength = obj.toString().length();

        assertTrue(obj.toString().charAt(0) == '\n');
        assertTrue(obj.toString().charAt(strLength - 1) == '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job obj = new Job("str", new Employer("ABC"), new Location("Street"),
                new PositionType("intern"), new CoreCompetency("Persistence"));

        String str = obj.toString();
        String idStr = String.valueOf(obj.getId());
        System.out.println(str);

        assertTrue(str.contains("ID: " + idStr + "\n"));
        assertTrue(str.contains("Name: str\n"));
        assertTrue(str.contains("Employer: ABC\n"));
        assertTrue(str.contains("Location: Street\n"));
        assertTrue(str.contains("Position Type: intern\n"));
        assertTrue(str.contains("Core Competency: Persistence\n"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job obj = new Job("str", new Employer(""), new Location("Street"),
                new PositionType("intern"), new CoreCompetency(""));

        String str = obj.toString();
        String idStr = String.valueOf(obj.getId());

        assertTrue(str.contains("ID: " + idStr + "\n"));
        assertTrue(str.contains("Name: str\n"));
        assertTrue(str.contains("Employer: Data not available\n"));
        assertTrue(str.contains("Location: Street\n"));
        assertTrue(str.contains("Position Type: intern\n"));
        assertTrue(str.contains("Core Competency: Data not available\n"));
    }

    @Test
    public void testToStringHandlesNonExistingJob() {
        Job obj = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        String str = obj.toString();
        String targetStr = "OOPS! This job does not seem to exist.";

        assertTrue(str.equals(targetStr));
    }
}
