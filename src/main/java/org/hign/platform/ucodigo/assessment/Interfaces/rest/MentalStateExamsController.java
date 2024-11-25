package org.hign.platform.ucodigo.assessment.Interfaces.rest;

import org.hign.platform.ucodigo.assessment.Domain.Exceptions.NationalProviderIdentifierException;
import org.hign.platform.ucodigo.assessment.Domain.Services.MentalStateExamsCommandService;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.CreateMentalStateExamsResource;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.MentalStateExamsResource;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.transform.CreateMentalStateExamsCommandFromResourceAssembler;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.transform.MentalStateExamsResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Mental State Exams Management Endpoints")
public class MentalStateExamsController {

    private final MentalStateExamsCommandService mentalStateExamsCommandService;

    public MentalStateExamsController(MentalStateExamsCommandService mentalStateExamsCommandService) {
        this.mentalStateExamsCommandService = mentalStateExamsCommandService;
    }

    @Operation(summary = "Create a Mental State Exams", description = "Creates a Mental State Exams with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mental State Exams created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<MentalStateExamsResource> createMentalStateExams(@RequestBody CreateMentalStateExamsResource resource) {
        var createMentalStateExamsResource = CreateMentalStateExamsCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExams = mentalStateExamsCommandService.handle(createMentalStateExamsResource);

        if (mentalStateExams.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var mentalExamsResource = MentalStateExamsResourceFromEntityAssembler.toResourceFromEntity(mentalStateExams.get());
        return new ResponseEntity<>(mentalExamsResource, HttpStatus.CREATED);
    }

    @ExceptionHandler(NationalProviderIdentifierException.class)
    public ResponseEntity<String> handleNationalProviderIdentifierException(NationalProviderIdentifierException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }




}
