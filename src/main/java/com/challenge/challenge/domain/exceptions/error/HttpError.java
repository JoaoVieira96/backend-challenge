package com.challenge.challenge.domain.exceptions.error;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpError {

    private HttpStatus status;
    private String message;
    private String description;
}
