package com.codecool.fplbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {

    @Id
    private long id;

    private Integer code;
    private String name;
    private String short_name;
    private Integer strength;

    private Integer strength_overall_home;
    private Integer strength_overall_away;
    private Integer strength_attack_home;
    private Integer strength_attack_away;
    private Integer strength_defence_home;
    private Integer strength_defence_away;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<Player> players = new HashSet<>();

}
