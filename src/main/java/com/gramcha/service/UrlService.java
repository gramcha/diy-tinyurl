/**
 * @author gramcha
 * 02-Jan-2018 3:43:02 PM
 * 
 */
package com.gramcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gramcha.entities.TinyUrl;

@Service
public class UrlService {

	@Autowired
	public KeyGenerator keyGen;
	public TinyUrl generateTinyUrl() {
		return null;
	}
}
