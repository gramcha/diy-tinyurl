/**
 * @author gramcha
 * 02-Jan-2018 3:35:31 PM
 * 
 */
package com.gramcha.entities;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TinyUrl {
	private String url;
	private String longUrl;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public TinyUrl() {
		
	}
	public TinyUrl(String tinyUrl, String longUrl) {
		this.url=tinyUrl;
		this.longUrl=longUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TinyUrl [url=");
		builder.append(url);
		builder.append(", longUrl=");
		builder.append(longUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
