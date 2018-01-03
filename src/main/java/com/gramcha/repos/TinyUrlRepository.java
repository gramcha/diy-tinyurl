/**
 * @author gramcha
 * 02-Jan-2018 6:03:12 PM
 * 
 */
package com.gramcha.repos;

import com.gramcha.entities.Url;

public interface TinyUrlRepository {

	void save(Url Url);
	
	Url findUrl(String key);
}
