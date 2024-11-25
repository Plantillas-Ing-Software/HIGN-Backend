package org.hign.platform.ucodigo.personnel.Application.Internal.commandservice;

import org.hign.platform.ucodigo.personnel.Domain.Exceptions.NationalProviderIdentifierAlreadyExitsException;
import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;
import org.hign.platform.ucodigo.personnel.Domain.Services.ExaminerCommandService;
import org.hign.platform.ucodigo.personnel.Infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the {@link ExaminerCommandService} for handling examiner-related commands.
 * This service is responsible for processing the creation of new examiners and ensuring that there are no duplicates
 * based on the National Provider Identifier.
 */
@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    /**
     * Constructs an {@link ExaminerCommandServiceImpl} with the provided {@link ExaminerRepository}.
     *
     * @param examinerRepository the repository responsible for handling the persistence of examiners.
     */
    @Autowired
    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Handles the creation of a new examiner based on the provided {@link CreateExaminerCommand}.
     * If an examiner with the same National Provider Identifier already exists, an exception is thrown.
     *
     * @param command the {@link CreateExaminerCommand} containing the data for the new examiner.
     * @return an {@link Optional} containing the created {@link Examiner}, or empty if the creation fails.
     * @throws NationalProviderIdentifierAlreadyExitsException if an examiner with the same
     * National Provider Identifier already exists.
     */
    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (examinerRepository.existsByNationalProviderIdentifier(command.nationalProviderIdentifier())){
            throw new NationalProviderIdentifierAlreadyExitsException("National provider already exists");
        }
        Examiner examiner = new Examiner(command);
        return Optional.of(examinerRepository.save(examiner));
    }
}