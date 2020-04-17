package ch.sixgroup.demo.neo4JProjekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class ProjectNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNeo4jApplication.class, args);
	}

}
