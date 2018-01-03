/**
 * @author gramcha
 * 02-Jan-2018 3:35:31 PM
 * 
 */
package com.gramcha.entities;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Url implements Serializable {
	private String tinyUrl;
	private String longUrl;
	private String key;
	
	public String getTinyUrl() {
		return tinyUrl;
	}
	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public Url() {
		
	}
	public Url(String tinyUrl, String longUrl) {
		this.tinyUrl=tinyUrl;
		this.longUrl=longUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Url [tinyUrl=");
		builder.append(tinyUrl);
		builder.append(", longUrl=");
		builder.append(longUrl);
		builder.append(", key=");
		builder.append(key);
		builder.append("]");
		return builder.toString();
	}
}
