// package com.stream.project.src;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class MovieConfig {

// 	@Bean
// 	CommandLineRunner commandLineRunner(MovieRepository repository) {
// 		return args -> {
// 			Movie lotr = new Movie("blank", "blank","Lotr");

			
// 			repository.saveAll(List.of(lotr));
// 		};
		
// 	}

// }