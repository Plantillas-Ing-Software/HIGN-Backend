package org.hign.platform.ucodigo.assessment.Application.Internal.commandservice;

import org.hign.platform.ucodigo.assessment.Application.Internal.outboundservices.acl.ExternalExaminerService;
import org.hign.platform.ucodigo.assessment.Domain.Exceptions.NationalProviderIdentifierException;
import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;
import org.hign.platform.ucodigo.assessment.Domain.Services.MentalStateExamsCommandService;
import org.hign.platform.ucodigo.assessment.Infrastructure.persistence.jpa.repositories.MentalStateExamsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Implementation of the MentalStateExamsCommandService interface.
 * This service handles commands related to mental state exams, such as creating new exams.
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamsCommandService {
    private final MentalStateExamsRepository mentalStateExamsRepository;
    private final ExternalExaminerService externalExaminerService;

    /**
     * Constructor for MentalStateExamCommandServiceImpl.
     *
     * @param mentalStateExamsRepository the repository to interact with mental state exam data.
     * @param externalExaminerService    the service to verify external examiners.
     */
    public MentalStateExamCommandServiceImpl(
            MentalStateExamsRepository mentalStateExamsRepository,
            ExternalExaminerService externalExaminerService) {
        this.mentalStateExamsRepository = mentalStateExamsRepository;
        this.externalExaminerService = externalExaminerService;
    }

    /**
     * Handles the creation of a new mental state exam.
     *
     * @param command the command containing details for creating the exam.
     * @return an Optional containing the created MentalStateExams entity, or an empty Optional if the creation fails.
     * @throws NationalProviderIdentifierException if:
     * - The examiner with the provided National Provider Identifier (NPI) does not exist.
     * - The exam date is in the future.
     * - An exam already exists for the provided NPI.
     */
    @Override
    public Optional<MentalStateExams> handle(CreateMentalStateExamCommand command) {
        if (!externalExaminerService.verifyExaminerExists(command.examinerNationalProviderIdentifier())) {
            throw new NationalProviderIdentifierException("Examiner not found with the provided NationalProviderIdentifier.");
        }

        if (command.examDate().isAfter(LocalDate.now())) {
            throw new NationalProviderIdentifierException("Exam date cannot be in the future.");
        }

        if (mentalStateExamsRepository.existsByExaminerNationalProviderIdentifier(command.examinerNationalProviderIdentifier())) {
            throw new NationalProviderIdentifierException("An exam already exists for the provided National Provider Identifier.");
        }

        MentalStateExams newExam = new MentalStateExams(command);
        return Optional.of(mentalStateExamsRepository.save(newExam));
    }
}