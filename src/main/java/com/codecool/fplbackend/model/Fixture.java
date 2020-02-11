package com.codecool.fplbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Fixture {

    @Id
    private long id;

    private long code;
    private boolean finished;
    private int event;
    private float team_h;
    private float team_a;
    private float team_h_difficulty;
    private float team_a_difficulty;
}
