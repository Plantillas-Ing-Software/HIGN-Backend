package org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.ucodigo.assessment.Domain.Model.Command.CreateMentalStateExamCommand;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.hign.platform.ucodigo.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class MentalStateExams extends AuditableAbstractAggregateRoot<MentalStateExams> {


    @Column(nullable = false)
    private Long patientId;

    @Embedded
    private NationalProviderIdentifier examinerNationalProviderIdentifier;

    @PastOrPresent(message = "The examDate timestamp must not be in the future")
    @Column(nullable = false)
    private LocalDate examDate;

    @Column(nullable = false)
    private Integer orientationScore;

    @Column(nullable = false)
    private Integer registrationScore;

    @Column(nullable = false)
    private Integer attentionAndCalculationScore;

    @Column(nullable = false)
    private Integer recallScore;

    @Column(nullable = false)
    private Integer languageScore;

    protected MentalStateExams() {}

    public MentalStateExams(CreateMentalStateExamCommand command){
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = command.examinerNationalProviderIdentifier();
        this.examDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();

        if (this.examDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Exam date cannot be in the future.");
        }
        if (isValidRange(this.orientationScore, 10)) {
            throw new IllegalArgumentException("Orientation score must be between 0 and 10.");
        }
        if (isValidRange(this.registrationScore, 3)) {
            throw new IllegalArgumentException("Registration score must be between 0 and 3.");
        }
        if (isValidRange(this.attentionAndCalculationScore, 5)) {
            throw new IllegalArgumentException("Attention and Calculation score must be between 0 and 5.");
        }
        if (isValidRange(this.recallScore, 3)) {
            throw new IllegalArgumentException("Recall score must be between 0 and 3.");
        }
        if (isValidRange(this.languageScore, 9)) {
            throw new IllegalArgumentException("Language score must be between 0 and 9.");
        }
    }

    private boolean isValidRange(Integer value, int max) {
        return value == null || value < 0 || value > max;
    }
}
