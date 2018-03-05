package com.lifeisbeautiful.shareyourthoughts.api;

public class InvalidRatingValueException extends Exception {
	
	public InvalidRatingValueException(String message) {
		super(message);
	}

	public InvalidRatingValueException() {
		super("Rating value should be between 1 and 5");
	}

}
