TOURIST MICROSERVICE - ECLIPSE IMPORT GUIDE
===========================================

Requirements:
- JDK 17
- Eclipse IDE for Enterprise Java and Web Developers (or Eclipse with Maven support)
- Internet connection for Maven to download dependencies

PROJECTS:
1. eureka-server  (port 8761)
2. tourist-service (instance 1 port 8081; instance 2 port 8082)
3. api-gateway (port 8080)

IMPORT INTO ECLIPSE:
1. Extract TouristMicroservice.zip.
2. Open Eclipse.
3. Select File > Import > Maven > Existing Maven Projects.
4. Browse to the extracted TouristMicroservice folder.
5. Select the root pom.xml (Eclipse should detect the three module POM files).
6. Click Finish and wait for Maven dependencies to download.
7. If needed, right-click the project > Maven > Update Project.

RUN IN THIS ORDER:
1. Right-click EurekaServerApplication.java > Run As > Java Application.
   Open http://localhost:8761 to see the Eureka dashboard.

2. Run TouristServiceApplication.java once as Java Application.
   It starts on port 8081.

3. Start a second TouristServiceApplication instance:
   - Open Run > Run Configurations...
   - Select Java Application > TouristServiceApplication.
   - Open the Arguments tab.
   - In Program arguments enter: --server.port=8082
   - Click Apply > Run.
   (If Eclipse creates a second launch configuration, use it for instance 2.)

4. Right-click ApiGatewayApplication.java > Run As > Java Application.
   It starts on port 8080.

TEST:
Open these URLs:
http://localhost:8761
http://localhost:8080/tourists
http://localhost:8080/tourists/places

Refresh the gateway URL several times. The response should show the instance port
(8081 or 8082), demonstrating load balancing.

NOTES:
- Start Eureka before the Tourist Service instances and API Gateway.
- All three applications must be running at the same time.
- The gateway uses lb://TOURIST-SERVICE and Spring Cloud LoadBalancer.
- If Maven dependencies fail to download, check internet access and JDK/Maven setup.
