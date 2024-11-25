package org.hign.platform.ucodigo.personnel.Application.Internal.commandservice;


import org.hign.platform.ucodigo.personnel.Domain.Exceptions.NationalProviderIdentifierAlreadyExitsException;
import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;
import org.hign.platform.ucodigo.personnel.Domain.Services.ExaminerCommandService;
import org.hign.platform.ucodigo.personnel.Infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    @Autowired
    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }


    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (examinerRepository.existsByNationalProviderIdentifier(command.nationalProviderIdentifier())){
            throw new NationalProviderIdentifierAlreadyExitsException("National provider already exists");
        }
        Examiner examiner = new Examiner(command);
        return Optional.of(examinerRepository.save(examiner));
    }
}
