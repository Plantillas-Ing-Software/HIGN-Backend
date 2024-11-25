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

/**
 * REST controller for managing mental state exams.
 * Provides endpoints to create and manage mental state exams in the system.
 */
@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Mental State Exams Management Endpoints")
public class MentalStateExamsController {

    private final MentalStateExamsCommandService mentalStateExamsCommandService;

    /**
     * Constructs a {@link MentalStateExamsController} with the provided command service.
     *
     * @param mentalStateExamsCommandService the service that handles mental state exam creation and other commands.
     */
    public MentalStateExamsController(MentalStateExamsCommandService mentalStateExamsCommandService) {
        this.mentalStateExamsCommandService = mentalStateExamsCommandService;
    }

    /**
     * Creates a new mental state exam with the provided resource data.
     *
     * @param resource the {@link CreateMentalStateExamsResource} containing the exam details.
     * @return a {@link ResponseEntity} with the created {@link MentalStateExamsResource} if successful,
     *         or a {@link ResponseEntity} with a 400 status if the request was invalid.
     */
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

    /**
     * Handles exceptions related to {@link NationalProviderIdentifierException}.
     *
     * @param ex the exception that was thrown.
     * @return a {@link ResponseEntity} with a 400 status and the exception message.
     */
    @ExceptionHandler(NationalProviderIdentifierException.class)
    public ResponseEntity<String> handleNationalProviderIdentifierException(NationalProviderIdentifierException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}