package fr.nadir.koudri.ProxiBanque.domain.client;

import fr.nadir.koudri.ProxiBanque.domain.account.Account;
import fr.nadir.koudri.ProxiBanque.domain.advisor.Advisor;
import fr.nadir.koudri.ProxiBanque.domain.card.BankCard;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    private List<BankCard> cards = new ArrayList<>();
}
