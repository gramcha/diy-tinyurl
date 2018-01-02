/**
 * @author gramcha
 * 02-Jan-2018 3:26:32 PM
 * 
 */
package com.gramcha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	@RequestMapping(value="/")
	public ResponseEntity<String> ping() throws Exception{
		return ResponseEntity.ok("pong - ");
	}
}
