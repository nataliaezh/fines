package com.hedgehogs.fines.repositories;

import com.hedgehogs.fines.entitties.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
    Letter findByTitle(String title);
}
