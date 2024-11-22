package org.hign.platform.ucodigo.assessment.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

import java.time.LocalDate;

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