package org.hign.platform.ucodigo.assessment.Interfaces.rest.transform;

import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;
import org.hign.platform.ucodigo.assessment.Interfaces.rest.resources.CreateMentalStateExamsResource;

/**
 * Assembler class responsible for converting a {@link CreateMentalStateExamsResource}
 * to a {@link CreateMentalStateExamCommand}.
 * This class provides the necessary transformation from the resource representation
 * of a mental state exam to the command object used in the service layer.
 */
public class CreateMentalStateExamsCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateMentalStateExamsResource} into a {@link CreateMentalStateExamCommand}.
     *
     * @param resource the {@link CreateMentalStateExamsResource} containing the data for creating a mental state exam.
     * @return a {@link CreateMentalStateExamCommand} constructed from the data in the resource.
     */
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