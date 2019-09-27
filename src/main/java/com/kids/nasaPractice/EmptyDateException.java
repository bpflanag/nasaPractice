package com.kids.nasaPractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "A date has not been given.")
public class EmptyDateException extends RuntimeException {
}
