package com.codecool.fplbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    private Set<Player> players;

}
