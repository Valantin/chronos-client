package it.infn.ba.indigo.chronos.client.model.v1;

import org.junit.Before;
import org.junit.Test;

import it.infn.ba.indigo.chronos.client.*;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

public class JobTest {
  private Chronos chronos;

  @Before
  public void setup() throws IOException {
    final Properties properties = new Properties();
    InputStream in = getClass().getResourceAsStream("application.properties");
    properties.load(in);

    chronos =
        ChronosClient.getInstanceWithBasicAuth(properties.getProperty("endpoint"),
            properties.getProperty("username"), properties.getProperty("password"));
  }

  public void getJobs() {
    Collection<Job> jobs = chronos.getJobs();
    System.out.println(jobs.toString());
  }

  public void getJob(String name) {
    Collection<Job> job = chronos.getJob(name);
    System.out.println(job.toString());
  }

  public void createJob(String name) throws ChronosException {
    Job job = new Job();
    job.setSchedule("R/2016-05-12T17:20:00Z/PT24H");
    job.setName(name);
    job.setOwner("junit");
    job.setEpsilon("PT15M");
    Container container = new Container();
    container.setType("DOCKER");
    container.setImage("libmesos/ubuntu");
    container.setForcePullImage(true);
    job.setContainer(container);
    job.setCpus(0.5);
    job.setMem(512.0);
    job.setCommand("echo hi; sleep 10; echo bye;");
    chronos.createJob(job);
  }

  public void createDependentJob(String name, List<String> parents) throws ChronosException {
    Job job = new Job();
    job.setName(name);
    job.setOwner("junit");
    job.setEpsilon("PT15M");
    job.setCommand("echo hi; sleep 10; echo bye;");
    job.setParents(parents);
    System.out.println(job.toString());
    chronos.createDependentJob(job);
  }

  public void deleteJob(String name) throws ChronosException {
    chronos.deleteJob(name);
  }

  public void startJob(String name) throws ChronosException {
    chronos.startJob(name);
  }

  @Test
  public void flow() throws ChronosException {
    createJob("junit-test-job-1");
    List<String> parents = new ArrayList<String>();
    parents.add("junit-test-job-1");
    createDependentJob("junit-test-depjob-1", parents);
    getJobs();
    getJob("junit-test-job-1");
    startJob("junit-test-job-1");
    deleteJob("junit-test-job-1");
    deleteJob("junit-test-depjob-1");
  }
}
