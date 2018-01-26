package com.therealdanvega.mtom;

import com.therealdanvega.mtom.domain.Category;
import com.therealdanvega.mtom.domain.Post;
import com.therealdanvega.mtom.domain.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MtomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtomApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(PostRepository postRepository) {
	    return args -> {
            Category springBoot = new Category("Spring Boot");
            Category springData = new Category("Spring Data");
            // if you don't PERSIST on the cascade type you need to save these off and flush before you can
            // add them to the post
            //categoryRepository.saveAndFlush(springBoot);
            //categoryRepository.saveAndFlush(springData);

//            Post post = new Post("Many to Many Mapping Demo","A demo on how to setup many to many mappings");
//            post.getCategories().add(springBoot);
//            post.getCategories().add(springData);
//            springBoot.getPosts().add(post);
//            springData.getPosts().add(post);

            // this is much easier with the addition of the helper methods
            Post post = new Post("Many to Many Mapping Demo","A demo on how to setup many to many mappings");
            post.addCategory(springBoot);
            post.addCategory(springData);
            postRepository.save(post);
            postRepository.save(post);

        };
    }
}
