package it.infn.ba.indigo.chronos.client;

import javax.inject.Named;

import feign.RequestLine;
import it.infn.ba.indigo.chronos.client.model.v1.GetJobsResponse;
import it.infn.ba.indigo.chronos.client.model.v1.Job;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;

public interface Chronos {

  @RequestLine("GET /scheduler/jobs")
  GetJobsResponse getJobs();

  @RequestLine("GET /scheduler/jobs/search?name={name}")
  GetJobsResponse getJob(@Named("name") String name);

  @RequestLine("POST /scheduler/iso8601")
  void createJob(Job job) throws ChronosException;

  @RequestLine("POST /scheduler/dependency")
  void createDependentJob(Job job) throws ChronosException;

  @RequestLine("PUT /scheduler/job/{name}")
  void startJob(@Named("name") String name) throws ChronosException;

  @RequestLine("DELETE /scheduler/job/{name}")
  void deleteJob(@Named("name") String name) throws ChronosException;

  @RequestLine("DELETE /scheduler/task/kill/{name}")
  void deleteJobTasks(@Named("name") String name) throws ChronosException;

}
