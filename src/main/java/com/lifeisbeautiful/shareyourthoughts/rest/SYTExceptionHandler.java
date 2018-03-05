package com.lifeisbeautiful.shareyourthoughts.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lifeisbeautiful.shareyourthoughts.api.InvaidUserNamePasswordException;
import com.lifeisbeautiful.shareyourthoughts.api.InvalidContentException;
import com.lifeisbeautiful.shareyourthoughts.api.PostNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.ResourceNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;
import com.lifeisbeautiful.shareyourthoughts.api.UserAlreadyExistsException;

@Provider
public class SYTExceptionHandler implements ExceptionMapper<SytException> {

	@Override
	public Response toResponse(SytException e) {
		if (e instanceof InvaidUserNamePasswordException) {
			
		}
		if (e instanceof InvalidContentException) {
			return Response.status(402).build();
		}
		if (e instanceof PostNotFoundException) {
			return Response.status(404).build();
		}
		if (e instanceof ResourceNotFoundException) {
			
		}
		if (e instanceof UnauthorizedUserException) {
			
		}
		if (e instanceof UserAlreadyExistsException) {
			
		}
		return Response.status(500).build();
	}

}
