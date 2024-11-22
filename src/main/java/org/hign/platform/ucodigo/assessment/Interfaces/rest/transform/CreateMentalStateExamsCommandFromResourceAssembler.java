package org.hign.platform.ucodigo.assessment.Interfaces.rest.transform;

import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.CreateMentalStateExamsResource;

public class CreateMentalStateExamsCommandFromResourceAssembler {

    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamsResource resource) {
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                resource.examDate(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
