package pl.coderslab.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "roles")
public class Role extends BaseEntity {

    public Role(@Size(max = 45) String role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    @Column(name = "role_id")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role")
    @Size(max = 45)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
