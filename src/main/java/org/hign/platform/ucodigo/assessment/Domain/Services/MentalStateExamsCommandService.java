package org.hign.platform.ucodigo.assessment.Domain.Services;

import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamsCommandService {

    Optional<MentalStateExams> handle(CreateMentalStateExamCommand command);
}
