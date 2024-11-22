package org.hign.platform.ucodigo.personnel.Domain.Model.Command;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;


public record CreateExaminerCommand(
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
