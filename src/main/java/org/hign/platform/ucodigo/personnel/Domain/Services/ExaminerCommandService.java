package org.hign.platform.ucodigo.personnel.Domain.Services;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;

import java.util.Optional;

/**
 * Service interface for handling commands related to examiner creation.
 * This service defines the contract for processing the creation of an examiner,
 * which includes validating the data and saving it to the repository.
 */
public interface ExaminerCommandService {

    /**
     * Handles the creation of a new examiner.
     * Validates the provided command and persists the new examiner if valid.
     *
     * @param command the {@link CreateExaminerCommand} containing the data for creating an examiner.
     * @return an {@link Optional} containing the created {@link Examiner}, or an empty {@link Optional}
     * if the creation fails.
     */
    Optional<Examiner> handle(CreateExaminerCommand command);
}
