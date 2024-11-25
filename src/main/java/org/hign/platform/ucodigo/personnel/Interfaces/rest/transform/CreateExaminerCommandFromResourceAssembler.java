package org.hign.platform.ucodigo.personnel.Interfaces.rest.transform;

import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.CreateExaminerResource;

/**
 * Assembler class responsible for converting a {@link CreateExaminerResource} to a {@link CreateExaminerCommand}.
 * This class allows the transformation of the resource data into a command for processing.
 */
public class CreateExaminerCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateExaminerResource} into a {@link CreateExaminerCommand}.
     * This method is used to create a command from the resource data, which is then handled by the service layer.
     *
     * @param resource the {@link CreateExaminerResource} containing the examiner data.
     * @return a {@link CreateExaminerCommand} with the data extracted from the resource.
     */
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}