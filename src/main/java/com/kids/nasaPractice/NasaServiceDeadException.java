package com.kids.nasaPractice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "NASA service is down.")
public class NasaServiceDeadException extends RuntimeException {
}