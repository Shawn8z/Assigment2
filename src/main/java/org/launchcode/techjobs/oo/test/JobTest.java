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

        assertTrue(obj.getId() > 0);

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
}
