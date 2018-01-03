/**
 * @author gramcha
 * 02-Jan-2018 3:43:02 PM
 * 
 */
package com.gramcha.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;
import com.gramcha.entities.Url;
import com.gramcha.repos.TinyUrlRepository;

@Service
public class UrlService {

	@Autowired
	public KeyGenerator keyGen;

	@Autowired
	public TinyUrlRepository tinyUrlRepository;

	// Map<String,Url> cache = new HashMap<>();

	public Url generateTinyUrl(String longUrl) {
		String key = keyGen.create();
		Url tinyUrl = new Url("http://localhost:8080/" + key, longUrl);
		// cache.put(key, tinyUrl);
		tinyUrl.setKey(key);
		updateRedisCache(tinyUrl);
		// System.out.println(cache.get(key).getTinyUrl());
		return tinyUrl;
	}

	private void updateRedisCache(Url url) {
		tinyUrlRepository.save(url);
	}

	public String getLongUrl(String tinyUrl) {
		// System.out.println("get long url for - "+tinyUrl);
		// if(cache.containsKey(tinyUrl)) {
		// return cache.get(tinyUrl).getLongUrl();
		// }
		Url urlInstance = tinyUrlRepository.findUrl(tinyUrl);
		if (urlInstance != null)
			return urlInstance.getLongUrl();
		// System.out.println("URL Instance = "+urlInstance);
		// System.out.println("cache = "+cache);
		return "https://en.wikipedia.org/wiki/HTTP_404";
	}
}
