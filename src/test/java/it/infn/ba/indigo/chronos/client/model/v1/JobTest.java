package it.infn.ba.indigo.chronos.client.model.v1;

import org.junit.Before;
import org.junit.Test;

import it.infn.ba.indigo.chronos.client.model.v1.Job;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobTest {
    private Job job;

    @Before
    public void setUp() {
        this.job = new Job();
    }

    /**
     * Test that roles can be added individually and duplicate roles
     * do not cause an issue.
     *
     * @throws Exception
     */
}