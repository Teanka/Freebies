package pl.coderslab.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String username;

    @Email(message = "Podaj prawidłowy adres email")
    @NotEmpty(message = "Podaj adres email")
    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Transient
    private String checkPass;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<GiveAway> giveAways;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

}
