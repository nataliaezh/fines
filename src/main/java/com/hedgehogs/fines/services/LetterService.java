package com.hedgehogs.fines.services;

import com.hedgehogs.fines.entitties.Debtor;
import com.hedgehogs.fines.entitties.Letter;
import com.hedgehogs.fines.repositories.DebtorRepository;
import com.hedgehogs.fines.repositories.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Service
public class LetterService {
    /*
    @Autowired
    public void setDebtorRepository(DebtorRepository debtorRepository) {
        this.debtorRepository = debtorRepository;
    }

    private DebtorRepository debtorRepository;

     */
    @Autowired
    public void setLetterRepository(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    private LetterRepository letterRepository;

    public List<Letter> findAll() {
        return (List<Letter>)letterRepository.findAll();
    }

    public Letter findById(Long id) {
        return letterRepository.findById(id).get();
    }
    public Letter findOneByTitle(String title) {
        return letterRepository.findByTitle(title);
    }
}
