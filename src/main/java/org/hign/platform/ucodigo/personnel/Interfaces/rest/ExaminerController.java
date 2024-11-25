package org.hign.platform.ucodigo.personnel.Interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.ucodigo.personnel.Domain.Exceptions.NationalProviderIdentifierAlreadyExitsException;
import org.hign.platform.ucodigo.personnel.Domain.Services.ExaminerCommandService;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.ExaminerResource;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing examiners.
 * This controller provides endpoints for creating examiners and handling related exceptions.
 */
@RestController
@RequestMapping(value = "/api/v1/examiner", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiner", description = "Examiner Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;

    /**
     * Constructor for the ExaminerController.
     *
     * @param examinerCommandService the service responsible for handling examiner-related commands.
     */
    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    /**
     * Endpoint for creating an examiner with the provided data.
     *
     * @param resource the {@link CreateExaminerResource} containing the data for the examiner to create.
     * @return a {@link ResponseEntity} containing the created {@link ExaminerResource} with a status of 201 if successful,
     * or a 400 status if there is an error.
     */
    @Operation(summary = "Create a Examiner", description = "Creates a Examiner with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Examiner created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);

        if (examiner.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }

    /**
     * Exception handler for {@link NationalProviderIdentifierAlreadyExitsException}.
     * This method returns a 400 response with the exception's message.
     *
     * @param ex the exception thrown when an examiner with the same National Provider Identifier already exists.
     * @return a {@link ResponseEntity} with the error message and a status of 400.
     */
    @ExceptionHandler(NationalProviderIdentifierAlreadyExitsException.class)
    public ResponseEntity<String> handleNationalProviderIdentifierAlreadyExitsException(NationalProviderIdentifierAlreadyExitsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}