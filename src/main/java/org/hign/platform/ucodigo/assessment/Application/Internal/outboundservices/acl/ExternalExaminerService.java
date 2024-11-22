package org.hign.platform.ucodigo.assessment.Application.Internal.outboundservices.acl;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.hign.platform.ucodigo.personnel.Interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

/**
 * ExternalExaminerService
 *
 * <p>
 * This class is an outbound service used by the Assessment Context to interact with the Personnel Context.
 * It is implemented as part of an anti-corruption layer (ACL) to decouple the Assessment Context from the Personnel Context.
 * </p>
 */
@Service
public class ExternalExaminerService {
    private final PersonnelContextFacade personnelContextFacade;

    public ExternalExaminerService(PersonnelContextFacade personnelContextFacade) {
        this.personnelContextFacade = personnelContextFacade;
    }

    /**
     * Verify if an examiner exists
     *
     * @param nationalProviderIdentifier the NPI to verify
     * @return true if examiner exists, false otherwise
     */
    public boolean verifyExaminerExists(NationalProviderIdentifier nationalProviderIdentifier) {
        return personnelContextFacade.verifyExaminerExists(nationalProviderIdentifier);
    }
}
