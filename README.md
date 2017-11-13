# SimpleHelloWorldJUnit5
This example will give an insight how we can levearge JUnit5 features in our test classes and how they are different than Junit4.

Simple Example which shows how we can modify pom.xml/gradle file so that we can have below scenerio's executed
 - For Running old Junit4 Test Classes with Junit5 , we need to add the dependencies for junit-platform-surefire-provider and junit- 
   vintage-engine plugin with maven –surefire-plugin
-  To execute Both New JUnit5 and Old JUnit4 Test Classes together, we need to add the dependency for junit-jupiter-engine.
-  To execute only New JUnit5 Test Classes, we need to add the dependency for junit-jupiter-engine and use maven-compiler-plugin to run 
   the test classes.
-  Add junit-platform-runner for executing tests and test suites on the JUnit Platform in a JUnit 4 environment(like in Eclipse IDE till 
   it supports JUnit5).
