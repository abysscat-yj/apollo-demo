package com.abysscat.apollo2;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description
 *
 * @Author: abysscat-yj
 * @Create: 2024/4/12 1:45
 */
@Configuration
@Import({Config1.class})
public class Config2 {

	@Bean
	public Config3 cc() {
		return new Config3();
	}

}