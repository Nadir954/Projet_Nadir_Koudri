package com.example.Projet_Nadir_Koudri.domain.client;

import com.example.Projet_Nadir_Koudri.domain.account.CheckingAccount;
import com.example.Projet_Nadir_Koudri.domain.account.SavingAccount;
import com.example.Projet_Nadir_Koudri.domain.advisor.Advisor;
import com.example.Projet_Nadir_Koudri.domain.card.BankCard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;

    @Embedded
    private Address address;

    @ManyToOne
    private Advisor advisor;

    @OneToOne(cascade = CascadeType.ALL)
    private CheckingAccount checkingAccount;

    @OneToOne(cascade = CascadeType.ALL)
    private SavingAccount savingAccount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BankCard> cards = new ArrayList<>();
}
