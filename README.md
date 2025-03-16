# dependecy-check-app

This project uses the OWASP Dependency Check to identify and report known vulnerabilities in project dependencies.

## Usage

To validate dependencies in the current project using the OWASP Dependency Check, run the following Maven command:

```sh
mvn org.owasp:dependency-check-maven:check
```

To build the project and run the OWASP Dependency Check, use the following Maven command:

```sh
mvn clean install
```

This command will clean the project, compile the source code, run the tests, and install the built artifacts into the local repository. Additionally, it will execute the OWASP Dependency Check as configured in the `pom.xml`.

## OWASP Dependency Check Plugin Configuration

The project uses the OWASP Dependency Check Maven plugin to identify and report known vulnerabilities in project dependencies. The plugin is configured in the `pom.xml` file as follows:

```xml
<plugin>
  <groupId>org.owasp</groupId>
  <artifactId>dependency-check-maven</artifactId>
  <version>6.5.3</version>
  <configuration>
    <reportSets>
      <reportSet>
        <reports>
          <report>aggregate</report>
        </reports>
      </reportSet>
    </reportSets>
  </configuration>
  <executions>
    <execution>
      <goals>
        <goal>check</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

## References

- [.gitignore](https://gist.github.com/dedunumax/54e82214715e35439227)
- [Set local username for Git](https://docs.github.com/en/get-started/getting-started-with-git/setting-your-username-in-git)
