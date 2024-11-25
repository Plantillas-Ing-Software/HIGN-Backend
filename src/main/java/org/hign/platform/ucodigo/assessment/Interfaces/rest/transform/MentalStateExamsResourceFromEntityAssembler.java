package org.hign.platform.ucodigo.assessment.Interfaces.rest.transform;

import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.MentalStateExamsResource;

/**
 * Assembler class responsible for converting a {@link MentalStateExams} entity to
 * a {@link MentalStateExamsResource}.
 * This class provides the necessary transformation from the domain entity to the resource
 * representation for API responses.
 */
public class MentalStateExamsResourceFromEntityAssembler {

    /**
     * Converts a {@link MentalStateExams} entity into a {@link MentalStateExamsResource}.
     *
     * @param entity the {@link MentalStateExams} entity containing the data for the mental state exam.
     * @return a {@link MentalStateExamsResource} constructed from the data in the entity.
     */
    public static MentalStateExamsResource toResourceFromEntity(MentalStateExams entity) {
        return new MentalStateExamsResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}