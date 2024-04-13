package com.abysscat.apollo1;

import com.abysscat.apollo2.Config1;
import com.abysscat.apollo2.Config2;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @Author: abysscat-yj
 * @Create: 2024/4/12 1:43
 */
@RestController
@SpringBootApplication
@EnableApolloConfig
@Import({Config2.class})
public class ApolloApplication {

	@Bean
	ApolloChangedListener listener(){
		return new ApolloChangedListener();
	}

	@Autowired
	Demo demo;
	@Autowired
	Config1 conf;

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}


	@GetMapping("/cf")
	public String cf() {
		System.out.println(demo.getA());
		System.out.println(conf);
		return demo.getA() + ",\n" + conf+ ",\n" + System.identityHashCode(conf);
	}

	@Autowired
	Environment environment;

	@Bean
	ApplicationRunner applicationRunner(@Autowired ApplicationContext context) {
		return x -> {
			System.out.println(demo.getA());
			System.out.println(conf);

			String pa = environment.getProperty("p.a");
			System.out.println(pa);

			ConfigurationPropertiesRebinder rebinder = context.getBean(ConfigurationPropertiesRebinder.class);
			System.out.println(rebinder);

		} ;
	}

}
