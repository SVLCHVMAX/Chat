package ru.simbirsoft.chat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"users"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String roleType;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<User> users;

    public Role(int id, String roleType) {
        this.id = id;
        this.roleType = roleType;
    }
}
