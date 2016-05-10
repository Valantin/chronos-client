package it.infn.ba.indigo.chronos.client.model.v1;

import java.util.List;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

public class GetJobsResponse {
  private List<Job> jobs;

  public List<Job> getJobs() {
    return jobs;
  }

  public void setJobs(List<Job> jobs) {
    this.jobs = jobs;
  }

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }

}
