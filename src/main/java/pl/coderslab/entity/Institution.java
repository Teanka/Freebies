package pl.coderslab.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "institutions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Institution extends BaseEntity{

    private String name;

    private String city;

    private String description;

    @OneToMany(mappedBy = "institution", fetch = FetchType.EAGER)
    private List<GiveAway> giveAways;

    private Boolean verified;
}
