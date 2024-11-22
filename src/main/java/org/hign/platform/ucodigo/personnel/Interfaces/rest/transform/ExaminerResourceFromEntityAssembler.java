package org.hign.platform.ucodigo.personnel.Interfaces.rest.transform;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {

    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier()
        );
    }
}
