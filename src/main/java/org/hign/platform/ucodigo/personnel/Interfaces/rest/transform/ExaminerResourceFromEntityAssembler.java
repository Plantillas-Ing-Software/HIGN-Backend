package org.hign.platform.ucodigo.personnel.Interfaces.rest.transform;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Interfaces.rest.resources.ExaminerResource;

/**
 * Assembler class responsible for converting an {@link Examiner} entity to an {@link ExaminerResource}.
 * This class allows the transformation of an entity into a resource for returning to the client.
 */
public class ExaminerResourceFromEntityAssembler {

    /**
     * Converts an {@link Examiner} entity into an {@link ExaminerResource}.
     * This method is used to create a resource from an entity, which is then returned to the client.
     *
     * @param entity the {@link Examiner} entity to convert.
     * @return an {@link ExaminerResource} representing the examiner entity.
     */
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier()
        );
    }
}