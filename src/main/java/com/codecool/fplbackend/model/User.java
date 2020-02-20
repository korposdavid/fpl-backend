package com.codecool.fplbackend.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @GeneratedValue
    @Id
    private Long id;

    private Integer githubId;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    private Set<Player> squad = new HashSet<>();
}
