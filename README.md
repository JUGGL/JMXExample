JMX Example
===========


An example of how to use MXBean annotations and JMX 2.0 APIs to create an easily managed and maintained Java application.

## Pre-requisites

1. Maven 3.x
2. Java 1.7.x
3. Internet access for Maven to download the dependencies

## Building

```
mvn clean package install
```

## Running

```
mvn exec:java -Dexec.mainClass=us.juggl.codepalousa.jmx.Main
```

## Trying It Out

Once you have the application running, open JConsole and connect to the process 