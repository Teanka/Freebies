package pl.coderslab.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "role")
    @Size(max = 45)
    private String name;
}
