package com.abysscat.apollo1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 *
 * @Author: abysscat-yj
 * @Create: 2024/4/12 1:42
 */
@Data
@Configuration
public class Demo {

	@Value("${p.a}")
	String a;

}