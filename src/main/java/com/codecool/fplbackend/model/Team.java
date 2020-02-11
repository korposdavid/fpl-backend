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
    public String shortName;
    public Integer strength;

    public Integer strengthOverallHome;
    public Integer strengthOverallAway;
    public Integer strengthAttackHome;
    public Integer strengthAttackAway;
    public Integer strengthDefenceHome;
    public Integer strengthDefenceAway;
}
