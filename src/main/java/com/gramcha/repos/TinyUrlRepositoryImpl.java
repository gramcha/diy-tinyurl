/**
 * @author gramcha
 * 02-Jan-2018 6:06:46 PM
 * 
 */
package com.gramcha.repos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.gramcha.entities.Url;

@Repository
public class TinyUrlRepositoryImpl implements TinyUrlRepository {

	private static final String KEY = "urlKey";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public TinyUrlRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }
    
	/* (non-Javadoc)
	 * @see com.gramcha.repos.TinyUrlRepository#save(com.gramcha.entities.Url)
	 */
	@Override
	public void save(Url url) {
		hashOperations.put(KEY, url.getKey(), url);
	}

	/* (non-Javadoc)
	 * @see com.gramcha.repos.TinyUrlRepository#findUrl(java.lang.String)
	 */
	@Override
	public Url findUrl(String key) {
		return (Url) hashOperations.get(KEY, key);
	}

}
//http://www.baeldung.com/spring-data-redis-tutorial