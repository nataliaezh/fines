package com.hedgehogs.fines.repositories;

import com.hedgehogs.fines.entitties.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
