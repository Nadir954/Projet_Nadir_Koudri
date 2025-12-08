package fr.nadir.koudri.ProxiBanque.domain.client;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {

    private String street;
    private String zipCode;
    private String city;
}
