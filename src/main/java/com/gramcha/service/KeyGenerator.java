/**
 * @author gramcha
 * 02-Jan-2018 3:38:36 PM
 * 
 */
package com.gramcha.service;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class KeyGenerator {
	public String create() {
		RandomStringGenerator randomStringGenerator =
		        new RandomStringGenerator.Builder()
		                .withinRange('0', 'z')
		                .filteredBy(CharacterPredicates.ASCII_ALPHA_NUMERALS, CharacterPredicates.DIGITS)
		                .build();
		return randomStringGenerator.generate(7);
	}
}
