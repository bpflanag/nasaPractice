package com.kids.nasaPractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "NASA service error.")
public class NasaServiceException extends RuntimeException {
}