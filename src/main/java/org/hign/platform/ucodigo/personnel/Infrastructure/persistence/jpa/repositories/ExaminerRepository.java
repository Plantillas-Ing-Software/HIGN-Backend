package org.hign.platform.ucodigo.personnel.Infrastructure.persistence.jpa.repositories;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

}
