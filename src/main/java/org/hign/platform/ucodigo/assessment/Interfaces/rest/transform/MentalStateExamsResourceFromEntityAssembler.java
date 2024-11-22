package org.hign.platform.ucodigo.assessment.Interfaces.rest.transform;

import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.MentalStateExamsResource;

public class MentalStateExamsResourceFromEntityAssembler {

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
