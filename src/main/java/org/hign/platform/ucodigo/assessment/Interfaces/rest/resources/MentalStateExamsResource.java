package org.hign.platform.ucodigo.assessment.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

import java.time.LocalDate;

/**
 * Resource representation for a mental state exam.
 * Acts as a data transfer object (DTO) for client output, including exam details and metadata.
 *
 * @param id                          The unique identifier of the mental state exam.
 * @param patientId                   The unique identifier of the patient who underwent the exam.
 * @param examinerNationalProviderIdentifier The National Provider Identifier (NPI) of the examiner who conducted the exam.
 * @param examDate                    The date the exam was conducted.
 * @param orientationScore            The score for the patient's orientation ability. Ranges from 0 to 10.
 * @param registrationScore           The score for the patient's registration ability. Ranges from 0 to 3.
 * @param attentionAndCalculationScore The score for the patient's attention and calculation ability. Ranges from 0 to 5.
 * @param recallScore                 The score for the patient's recall ability. Ranges from 0 to 3.
 * @param languageScore               The score for the patient's language ability. Ranges from 0 to 9.
 */
public record MentalStateExamsResource(
        Long id,
        Long patientId,
        NationalProviderIdentifier examinerNationalProviderIdentifier,
        LocalDate examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {}