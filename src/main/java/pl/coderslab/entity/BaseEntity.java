package pl.coderslab.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

//    Invocation of init method failed; nested exception is org.hibernate.HibernateException:
// Unsupported property type for generator annotation @CreationTimestamp
    @CreationTimestamp
    protected LocalDate created;

    @UpdateTimestamp
    protected LocalDate modified;
}
