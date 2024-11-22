package org.hign.platform.ucodigo.personnel.Interfaces.rest.transform;

import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {

    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}
