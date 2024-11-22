package org.hign.platform.ucodigo.personnel.Domain.Services;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {

    Optional<Examiner> handle(CreateExaminerCommand command);
}
