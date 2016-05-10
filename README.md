# chronos-client

This project is a Java library for communicating with Chronos API. At this point this library supports version v1 of chronos API, please refer [docs](https://mesos.github.io/chronos/docs/api.html) for more details.

## Using chronos-client in your maven project

Add chronos-client as a dependency:

```
<dependency>
  <groupId>com.mesosphere</groupId>
  <artifactId>chronos-client</artifactId>
  <version>0.0.1</version>
</dependency>
```


## Usage

### Initialization

The following piece of code initializes the client. ```ChronosClient.getInstance()``` method expects the endpoint for chronos:

```
String endpoint = "<endpoint>";
Chronos chronos = ChronosClient.getInstance(endpoint);
```

for Basic Auth

```
String endpoint = "<endpoint>";
String username = "<username>";
String password = "<password>";
Chronos chronos = ChronosClient.getInstanceWithBasicAuth(endpoint,username,password);
```

### Getting all jobs

The following will return all the jobs that have been created:

```
GetJobsResponse jobsResponse = chronos.getJobs();
```

### Create a new job

The following example demonstrates how a new job can be created:
```
Job job = new Job();
job.setSchedule("R\/2016-04-27T17:22:00Z\/PT5M"):
job.setName("dockerjob");
Container container = new Container();
container.setType("DOCKER");
container.setImage("libmesos/ubuntu");
job.setContainer(container);
job.setCpus(0.5);
job.setMem(512.0);
job.setCommand("echo hi; sleep 10; echo bye;");

chronos.createJob(job);
```

### Get details about an existing job

The following example, demostrates how to get details about an already created job:

```
GetJobsResponse jobGet = chronos.getJob("dockerjob");
```

### Delete a job

The following example demostrate, how one can delete an existing application:
```
chronos.deleteJob("dockerjob");
```

## Building

This project is built using [Apache Maven](http://maven.apache.org/).

Run the following command from the root of repository, to build the client JAR:

```
$ mvn clean install
```

## Bugs

Bugs can be reported using Github issues.
