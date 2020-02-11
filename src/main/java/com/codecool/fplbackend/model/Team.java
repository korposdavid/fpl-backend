package com.codecool.fplbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    private long id;

    public Integer code;
    public String name;
    public String short_name;
    public Integer strength;

    public Integer strength_overall_home;
    public Integer strength_overall_away;
    public Integer strength_attack_home;
    public Integer strength_attack_away;
    public Integer strength_defence_home;
    public Integer strength_defence_away;
}
