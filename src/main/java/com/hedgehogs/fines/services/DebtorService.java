package com.hedgehogs.fines.services;

import com.hedgehogs.fines.entitties.Debtor;
import com.hedgehogs.fines.repositories.DebtorRepository;
import com.hedgehogs.fines.repositories.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Service
public class DebtorService {
    @Autowired
    public void setDebtorRepository(DebtorRepository debtorRepository) {
        this.debtorRepository = debtorRepository;
    }

    @Autowired
    public void setLetterRepository(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    private DebtorRepository debtorRepository;
    private LetterRepository letterRepository;

    public List<Debtor> findAll() {
        return (List<Debtor>)debtorRepository.findAll();
    }

    public Debtor findById(Long id) {
        return debtorRepository.findById(id).get();
    }

}
