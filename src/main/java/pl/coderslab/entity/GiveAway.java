package pl.coderslab.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "giveAways")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GiveAway extends BaseEntity{

    @ManyToOne
    private Institution institution;

    private String description;

    @ManyToOne
    private User user;

}
