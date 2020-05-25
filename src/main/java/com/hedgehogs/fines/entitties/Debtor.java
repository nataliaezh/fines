package com.hedgehogs.fines.entitties;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Entity
@Table(name = "debtors")
@Data
@NoArgsConstructor
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sumdebt")
    private String sumdebt;

}
