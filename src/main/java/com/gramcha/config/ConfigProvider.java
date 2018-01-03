/**
 * @author gramcha
 * 22-Dec-2017 7:03:21 PM
 * 
 */
package com.gramcha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ConfigProvider {
	@Autowired
	private Environment env;

	public String getRedisIpAddress() {
		return env.getProperty("spring.redis.host");
	}
	public String getRedisPortNumber() {
		return env.getProperty("spring.redis.port");
	}
	public String getRedisCacheExpirationSeconds() {
		return env.getProperty("spring.redis.cache.expiration");
	}
}
