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

/**
 * Entity representing a mental state exam.
 * Captures details about a patient's mental state assessment, including scores for
 * various cognitive domains such as orientation, registration, attention, recall, and language.
 * Extends {@link AuditableAbstractAggregateRoot} to include audit fields.
 */
@Setter
@Getter
@Entity
public class MentalStateExams extends AuditableAbstractAggregateRoot<MentalStateExams> {


    @Column(nullable = false)
    private Long patientId;

    /**
     * The National Provider Identifier (NPI) of the examiner conducting the exam.
     * Stored as an embedded object.
     */
    @Embedded
    private NationalProviderIdentifier examinerNationalProviderIdentifier;

    /**
     * The date the mental state exam was conducted.
     * Must not be in the future.
     */
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

    /**
     * Constructs a new MentalStateExams entity using data from the given command.
     *
     * @param command the {@link CreateMentalStateExamCommand} containing the data for this exam.
     * @throws IllegalArgumentException if:
     *  - The exam date is in the future.
     *  - Any of the scores are outside their valid range.
     */
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

    /**
     * Validates if a score is within the range of 0 to the given maximum.
     *
     * @param value the score to validate.
     * @param max   the maximum valid value for the score.
     * @return true if the score is null, less than 0, or greater than max; false otherwise.
     */
    private boolean isValidRange(Integer value, int max) {
        return value == null || value < 0 || value > max;
    }
}
