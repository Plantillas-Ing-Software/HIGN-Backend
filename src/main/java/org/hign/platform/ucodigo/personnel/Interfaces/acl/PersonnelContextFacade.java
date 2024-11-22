package org.hign.platform.ucodigo.personnel.Interfaces.acl;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.hign.platform.ucodigo.personnel.Infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

/**
 * Service Facade for the Personnel context.
 *
 * <p>
 * This facade is used by other contexts to interact with the Personnel context.
 * It is implemented as part of an anti-corruption layer (ACL) to maintain context boundaries.
 * </p>
 */
@Service
public class PersonnelContextFacade {
    private final ExaminerRepository examinerRepository;

    public PersonnelContextFacade(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Verifies if an examiner exists by their National Provider Identifier
     *
     * @param nationalProviderIdentifier the NPI to search for
     * @return true if examiner exists, false otherwise
     */
    public boolean verifyExaminerExists(NationalProviderIdentifier nationalProviderIdentifier) {
        return examinerRepository.existsByNationalProviderIdentifier(nationalProviderIdentifier);
    }

}