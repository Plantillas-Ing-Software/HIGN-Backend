package org.hign.platform.ucodigo.assessment.Domain.Model.Command;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

import java.time.LocalDate;

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