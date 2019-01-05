package pl.coderslab.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address extends BaseEntity{

    @OneToOne(mappedBy = "address")
    private User user;

    private String street;

    private String city;

    private String postalCode;

    private String phone;
}