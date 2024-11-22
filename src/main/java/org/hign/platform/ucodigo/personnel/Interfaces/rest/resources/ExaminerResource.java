package org.hign.platform.ucodigo.personnel.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
