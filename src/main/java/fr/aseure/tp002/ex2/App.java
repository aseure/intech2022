package fr.aseure.tp002.ex2;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    // Here is how to configure the maven-jar-plugin in your pom.xml. Your
    // mileage may vary regarding how to configure the <mainClass> value.
    //
    // You should then be able to run the `mvn package` command which will
    // generate an executable JAR file in the target/ directory, which you can
    // run with the `java -jar <YOUR_JAR_FILE>` command
    //
    // For better instructions on how to configure the different values, please
    // refer to the Java course itself which contains links to the appropriate
    // correct pages.

    // <plugin>
    //     <groupId>org.apache.maven.plugins</groupId>
    //     <artifactId>maven-jar-plugin</artifactId>
    //     <version>3.2.2</version>
    //     <configuration>
    //         <archive>
    //             <manifest>
    //                 <addClasspath>true</addClasspath>
    //                 <mainClass>fr.aseure.tp002.ex2.App</mainClass>
    //             </manifest>
    //         </archive>
    //     </configuration>
    // </plugin>
}