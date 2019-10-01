# Building Web Services with Java EE 8<br>Section 1: Getting Started

Now you can build the project and deploy the final artifact to your Payara Server.

```bash
$ mvn clean package
```

## Containerization

To containerize our microservice, we have to write a `Dockerfile`. See the `step-04`
branch for the final result.

First, we need to decide which container base image to use. Have a look at Docker Hub.
The two options presented here are:

* Payara Server Full 5.0
* Payara Micro 5.0

Add a `Dockerfile` to the base directory of this project and add the following content:

```
FROM payara/server-full:5.181
COPY target/hello-javaee8.war $DEPLOY_DIR
```

To build the image and run it as a container, open a command prompt and issue the following
shell commands:
```bash
$ mvn package

$ docker build -t hello-javaee8:1.0-full .
$ docker run -it -p 8080:8080 hello-javaee8:1.0-full
```

You should now be able to access the web service under the IP of you Docker host.

Next, we want to use the Payara Micro base image instead. Add the following content to the `Dockerfile`:
```
FROM payara/micro:5.181
COPY target/hello-javaee8.war /opt/payara/deployments
```

To build the image and run it as a container, open a command prompt and issue the following
shell commands:
```bash
$ mvn package

$ docker build -t hello-javaee8:1.0-micro .
$ docker run -it -p 8080:8080 hello-javaee8:1.0-micro
```

Again, you should now be able to access the web service under the IP of you Docker host.
