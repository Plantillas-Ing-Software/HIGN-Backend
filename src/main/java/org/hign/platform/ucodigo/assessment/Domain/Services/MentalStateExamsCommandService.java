package org.hign.platform.ucodigo.assessment.Domain.Services;

import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;

import java.util.Optional;

/**
 * Service interface for handling commands related to mental state exams.
 * Provides methods to process and execute operations such as creating new exams.
 */
public interface MentalStateExamsCommandService {

    /**
     * Handles the creation of a mental state exam based on the provided command.
     *
     * @param command the {@link CreateMentalStateExamCommand} containing the details for the exam.
     * @return an {@link Optional} containing the created {@link MentalStateExams} entity if successful,
     *         or an empty {@link Optional} if the creation failed.
     */
    Optional<MentalStateExams> handle(CreateMentalStateExamCommand command);
}