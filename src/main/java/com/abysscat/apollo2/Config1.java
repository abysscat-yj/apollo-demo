package com.abysscat.apollo2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Description
 *
 * @Author: abysscat-yj
 * @Create: 2024/4/12 1:45
 */
@Data
//@Configuration
@ConfigurationProperties(prefix = "p")
//@RefreshScope
public class Config1 {
	String a;
	String b;
	Map<String,String> c;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
}
