package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Job implements Serializable {

  private static final long serialVersionUID = 4299892262923776898L;

  private String name;
  private String description;
  private String command;
  private List<String> arguments;
  private Boolean shell;
  private String epsilon;
  private String executor;
  private String executorFlags;
  private Integer retries;
  private String owner;
  private String ownerName;
  private Boolean async;
  private Integer successCount;
  private Integer errorCount;
  private String lastSuccess;
  private String lastError;
  private Double cpus;
  private Double mem;
  private Double disk;
  private Boolean disabled;
  private Collection<String> uris;
  private String schedule;
  private String scheduleTimeZone;
  private List<String> parents;
  private String runAsUser;
  private Container container;
  private Boolean dataJob;
  private List<EnvironmentVariable> environmentVariables;
  private List<List<String>> constraints;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public List<String> getArguments() {
    return arguments;
  }

  public void setArguments(final List<String> arguments) {
    this.arguments = arguments;
  }

  public Boolean isShell() {
    return shell;
  }

  public void setShell(Boolean shell) {
    this.shell = shell;
  }

  public String getEpsilon() {
    return epsilon;
  }

  public void setEpsilon(String epsilon) {
    this.epsilon = epsilon;
  }

  public String getExecutor() {
    return executor;
  }

  public void setExecutor(String executor) {
    this.executor = executor;
  }

  public String getExecutorFlags() {
    return executorFlags;
  }

  public void setExecutorFlags(String executorFlags) {
    this.executorFlags = executorFlags;
  }

  public Integer getRetries() {
    return retries;
  }

  public void setRetries(Integer retries) {
    this.retries = retries;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public Boolean getAsync() {
    return async;
  }

  public void setAsync(Boolean async) {
    this.async = async;
  }

  public Integer getSuccessCount() {
    return successCount;
  }

  public void setSuccessCount(Integer successCount) {
    this.successCount = successCount;
  }

  public Integer getErrorCount() {
    return errorCount;
  }

  public void setErrorCount(Integer errorCount) {
    this.errorCount = errorCount;
  }

  public String getLastSuccess() {
    return lastSuccess;
  }

  public void setLastSuccess(String lastSuccess) {
    this.lastSuccess = lastSuccess;
  }

  public String getLastError() {
    return lastError;
  }

  public void setLastError(String lastError) {
    this.lastError = lastError;
  }

  public Double getCpus() {
    return cpus;
  }

  public void setCpus(Double cpus) {
    this.cpus = cpus;
  }

  public Double getMem() {
    return mem;
  }

  public void setMem(Double mem) {
    this.mem = mem;
  }

  public Double getDisk() {
    return disk;
  }

  public void setDisk(Double disk) {
    this.disk = disk;
  }

  public Boolean getDisabled() {
    return disabled;
  }

  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  public Collection<String> getUris() {
    return uris;
  }

  public void setUris(Collection<String> uris) {
    this.uris = uris;
  }

  public void addUri(String uri) {
    if (this.uris == null) {
      this.uris = new ArrayList<String>();
    }
    this.uris.add(uri);
  }

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public String getScheduleTimeZone() {
    return scheduleTimeZone;
  }

  public void setScheduleTimeZone(String scheduleTimeZone) {
    this.scheduleTimeZone = scheduleTimeZone;
  }

  public List<String> getParents() {
    return parents;
  }

  public void setParents(List<String> parents) {
    this.parents = parents;
  }

  public String getRunAsUser() {
    return runAsUser;
  }

  public void setRunAsUser(String runAsUser) {
    this.runAsUser = runAsUser;
  }

  public Container getContainer() {
    return container;
  }

  public void setContainer(Container container) {
    this.container = container;
  }

  public Boolean getDataJob() {
    return dataJob;
  }

  public void setDataJob(Boolean dataJob) {
    this.dataJob = dataJob;
  }

  public List<EnvironmentVariable> getEnvironmentVariables() {
    return environmentVariables;
  }

  public void setEnvironmentVariables(List<EnvironmentVariable> environmentVariables) {
    this.environmentVariables = environmentVariables;
  }

  public List<List<String>> getConstraints() {
    return constraints;
  }

  public void setConstraints(List<List<String>> constraints) {
    this.constraints = constraints;
  }

  public void addConstraint(String attribute, String operator, String value) {
    if (this.constraints == null) {
      this.constraints = new ArrayList<List<String>>();
    }
    List<String> constraint = new ArrayList<String>(3);
    constraint.add(attribute == null ? "" : attribute);
    constraint.add(operator == null ? "" : operator);
    constraint.add(value == null ? "" : value);
    this.constraints.add(constraint);
  }

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }

}
