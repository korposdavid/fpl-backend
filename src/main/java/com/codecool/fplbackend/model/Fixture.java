package com.codecool.fplbackend.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
}
