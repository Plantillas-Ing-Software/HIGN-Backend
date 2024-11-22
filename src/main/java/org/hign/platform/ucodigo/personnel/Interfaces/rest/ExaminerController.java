package org.hign.platform.ucodigo.personnel.Interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.ucodigo.personnel.Domain.Services.ExaminerCommandService;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.ExaminerResource;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/examiner", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiner", description = "Examiner Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;

    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

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



}
