package it.infn.ba.indigo.chronos.client;

import java.util.Collection;

import feign.RequestLine;
import feign.Param;
import feign.Headers;

import it.infn.ba.indigo.chronos.client.model.v1.Job;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;

public interface Chronos {

  @RequestLine("GET /scheduler/jobs")
  Collection<Job> getJobs();

  @RequestLine("GET /scheduler/jobs/search?name={name}")
  Collection<Job> getJob(@Param("name") String name);

  @Headers("Content-Type: application/json")
  @RequestLine("POST /scheduler/iso8601")
  void createJob(Job job) throws ChronosException;

  @Headers("Content-Type: application/json")
  @RequestLine("POST /scheduler/dependency")
  void createDependentJob(Job job) throws ChronosException;

  @RequestLine("PUT /scheduler/job/{name}")
  void startJob(@Param("name") String name) throws ChronosException;

  @RequestLine("DELETE /scheduler/job/{name}")
  void deleteJob(@Param("name") String name) throws ChronosException;

  @RequestLine("DELETE /scheduler/task/kill/{name}")
  void deleteJobTasks(@Param("name") String name) throws ChronosException;

}
