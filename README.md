# Sample SpringBoot Prometheus Remote Writer

This project implements the remote_writer interface for prometheus to capture metrics and serialize each sample as json. It is intended just as an example to show how to do it simple with java, because most examples are developed in golang.

## Building

To recompile protobuf files, you may have protoc (protobuf compiler). In linux, you can install protobuf-compiler package to provide it. 

The project can be built with

    mvn clean install

## Testing the component

To test it, run with

	mvn spring-boot:run
	
and configure prometheus adding

```
remote_write:
  - url: 'http://<your-endpoint>/write'
```



