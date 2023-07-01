package com.challenge.challenge.domain.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpException extends Throwable {

    private HttpStatus status;
    private String message;
    private String description;
}
