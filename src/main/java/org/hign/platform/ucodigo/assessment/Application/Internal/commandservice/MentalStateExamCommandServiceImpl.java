package org.hign.platform.ucodigo.assessment.Application.Internal.commandservice;

import org.hign.platform.ucodigo.assessment.Application.Internal.outboundservices.acl.ExternalExaminerService;
import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;
import org.hign.platform.ucodigo.assessment.Domain.Services.MentalStateExamsCommandService;
import org.hign.platform.ucodigo.assessment.Infrastructure.persistence.jpa.repositories.MentalStateExamsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamsCommandService {
    private final MentalStateExamsRepository mentalStateExamsRepository;
    private final ExternalExaminerService externalExaminerService;

    public MentalStateExamCommandServiceImpl(
            MentalStateExamsRepository mentalStateExamsRepository,
            ExternalExaminerService externalExaminerService) {
        this.mentalStateExamsRepository = mentalStateExamsRepository;
        this.externalExaminerService = externalExaminerService;
    }

    @Override
    public Optional<MentalStateExams> handle(CreateMentalStateExamCommand command) {
        if (!externalExaminerService.verifyExaminerExists(command.examinerNationalProviderIdentifier())) {
            throw new IllegalArgumentException("Examiner not found with the provided NationalProviderIdentifier.");
        }

        if (command.examDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Exam date cannot be in the future.");
        }

        boolean examExists = mentalStateExamsRepository.existsByExaminerNationalProviderIdentifierAndPatientId(
                command.examinerNationalProviderIdentifier(), command.patientId());

        if (examExists) {
            throw new IllegalArgumentException("An exam already exists for this patient and examiner.");
        }

        MentalStateExams newExam = new MentalStateExams(command);
        return Optional.of(mentalStateExamsRepository.save(newExam));
    }
}