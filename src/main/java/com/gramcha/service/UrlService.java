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

import com.gramcha.entities.TinyUrl;

@Service
public class UrlService {

	@Autowired
	public KeyGenerator keyGen;
	Map<String,TinyUrl> cache = new HashMap<>();
	public TinyUrl generateTinyUrl(String longUrl) {
		String key = keyGen.create();
		TinyUrl tinyUrl = new TinyUrl("http://localhost:8080/"+key,longUrl); 
		cache.put(key, tinyUrl);
		System.out.println(cache.get(key).getUrl());
		return tinyUrl;
	}
	public String getLongUrl(String tinyUrl) {
		System.out.println("get long url for - "+tinyUrl);
		if(cache.containsKey(tinyUrl)) {
			return cache.get(tinyUrl).getLongUrl();
		}
		System.out.println("cache = "+cache);
		return "https://en.wikipedia.org/wiki/HTTP_404";
	}
}
