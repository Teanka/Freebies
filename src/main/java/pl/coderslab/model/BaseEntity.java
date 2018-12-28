package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

//    @CreationTimestamp
//    protected LocalDate created;
//
//    @UpdateTimestamp
//    protected LocalDate modified;
}
