package com.esprit.pi.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}