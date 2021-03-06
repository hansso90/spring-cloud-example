# Spring cloud example

Project to discover all ins and outs about de spring-cloud dependecies

## Discovery with Eureka

Modules:
- Discovery Server
- Discovery Service
- Discovery Client
- Config Server
- Config client
- Zuul gateway
- Ribbon time Service
- Ribbon time app
- Hystrix-weather-service
- Hystrix-weather-app
- Hystrix-dashboard
- Hystrix-turbine

### Demo of Eureka:

Modules needed for demo:
- Discovery-server;
- Discovery-service; (x2)
- Discovery-client;

First of all start de discovery server module. With http://localhost:8761/eureka you can see which services has called in.

Start the discovery service module with the following environment variable:
-Dserver.port = 8000
-Dservice.instance.name = discovery-service 1
See at euerka if Discovery-service 1 has called in

Start a new discovery service with port 8001 en instance name: discovery-service 2
Look again if the service gives a notice to eureka;

For the last service start the discovery-client; Go to the next url: http://localhost:8080 and check the response;

### Demo config with discovery first

Modules needed for demo:
- Discovery-server;
- Config-server;
- Config-client; (x2)

First of all start de discovery server module. With http://localhost:8761/eureka you can see which services has called in.

Start the config-server application, it will register itself at eureka with port 8888. The config server will look in github for 
the right configuration. See also the config folder in the project.

Now you must start the config-client with two different properties.
Start the first one without any environment variable and one with environment variable 
-Dspring.profiles.active = test and -Dserver.port= 8081

Access the browser the two different applications. Call one url:
http://localhost:8080/property
http://localhost:8081/property

See that they are loaded with different configuration;

### Demo of Zuul gateway
Modules needed for demo:
- Discovery-server;
- Discovery-service; (x2)
- Zuul-gateway;

First of all start de discovery server module. With http://localhost:8761/eureka you can see which services has called in.

Start the discovery service module with the following environment variable:
-Dserver.port = 8000
-Dservice.instance.name = discovery-service 1
See at euerka if Discovery-service 1 has called in

Start a new discovery service with port 8001 en instance name: discovery-service 2
Look again if the service gives a notice to eureka;

Now start de Zuul-gateway project and check if it is registered by eureka.
Then open a browser a go to http://localhost:8080/discovery-service, refresh the browsers a couple of times to see whats happend.

### Demo of Ribbon Loadbalancing with discovery
Modules needed for demo:
- Discovery-server;
- RibbonTimeService; (x2)
- RibbonTimeApp;

First of all start de discovery server module. With http://localhost:8761/eureka you can see which services has called in.

Start the RibbonTimeService with the following environment variable:

First: -Dserver.port=4444
Second: -Dserver.port=5555

Start the RibbonTimeApp and open a browser for http://localhost:8080, to see the results.

### Demo of Hystrix

Modules needed for demo:
- Discovery-server;
- Hystrix-weather-service
- Hystrix-weather-app
- Hystrix-dashboard
- Hystrix-turbine

First of all start de discovery server module. With http://localhost:8761/eureka you can see which services has called in.

Start the weather service and check if there is a message from http://localhost:9000/weather

Start the Hystrix-weather-app en check if there is a message from http://localhost:9001/current/weather

Turn off the weather service en check the url of Hystrix-weather-app again. 

Next start the hystrix-dashboard and go to http://localhost:8080/hystrix and enter the following:
- Enter http://localhost:9001/hystrix.stream
- call it the weather app

Start the weather service again en refresh a couple of time on http://localhost:9001/current/weather
See the changes in the metrics

Turbine is a application for combining hystrix metrics from different services, for my demo i only just added one service. 
If you have more services add them to the hystrix-turbine in de application.yml.
The will be located with the right name with the discovery service. 

Enter for the full metrics the turbine stream of the turbine project, located on http://localhost:3000/turbine.stream. 











