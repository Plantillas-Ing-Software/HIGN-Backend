package org.hign.platform.ucodigo.personnel.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

public record CreateExaminerResource(
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
