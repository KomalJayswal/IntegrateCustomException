package net.learning.IntegrateCustomException.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.learning.ExceptionHandlerUtility.exceptions.CustomException;
import net.learning.IntegrateCustomException.model.Request;
import net.learning.IntegrateCustomException.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/imports")
public class Controller {

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/vessel-voyage/documents")
    public ResponseEntity<Response> submitImportDocument(
            @RequestBody Request requestPayload,
            @RequestHeader("X-Correlation-ID") String correlationId, @RequestHeader("X-Tenant-ID") String tenantId,
            @RequestHeader("X-GCSS-Authorization") String gcssAuthorization) {

        Response res = Response.builder()
                .data("komal")
                .build();

        if(correlationId.equals("komal"))
        throw new CustomException(400,"ERRORSS");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }
}
