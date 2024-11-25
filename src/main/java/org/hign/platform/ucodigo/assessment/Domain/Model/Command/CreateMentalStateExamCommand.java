package org.hign.platform.ucodigo.assessment.Domain.Model.Command;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

import java.time.LocalDate;

/**
 * Command object for creating a new mental state exam.
 * Encapsulates all the necessary data required to create a mental state exam entity.
 * This is a record, ensuring immutability and easy value handling.
 *
 * @param patientId                   The unique identifier of the patient undergoing the exam.
 * @param examinerNationalProviderIdentifier The National Provider Identifier (NPI) of the examiner conducting the exam.
 * @param examDate                    The date the exam was conducted. Must not be in the future.
 * @param orientationScore            The score for the patient's orientation ability. Must be between 0 and 10.
 * @param registrationScore           The score for the patient's registration ability. Must be between 0 and 3.
 * @param attentionAndCalculationScore The score for the patient's attention and calculation ability. Must be between 0 and 5.
 * @param recallScore                 The score for the patient's recall ability. Must be between 0 and 3.
 * @param languageScore               The score for the patient's language ability. Must be between 0 and 9.
 */
public record CreateMentalStateExamCommand(
        Long patientId,
        NationalProviderIdentifier examinerNationalProviderIdentifier,
        LocalDate examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {}