package com.codecool.fplbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {

    @Id
    private long id;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Team teamObject;

    private String fullName;

    private float code;
    private float element_type;
    private float event_points;
    private String first_name;
    private String form;
    private String news;
    private float now_cost;
    private String photo;
    private String points_per_game;
    private String second_name;
    private String status;
    private long team;
    private float total_points;

    private String value_form;
    private String value_season;
    private String web_name;
    private float minutes;
    private float goals_scored;
    private float assists;
    private float clean_sheets;
    private float goals_conceded;
    private float own_goals;
    private float penalties_saved;
    private float penalties_missed;
    private float yellow_cards;
    private float red_cards;
    private float saves;
    private float bonus;
    private float bps;
    private String influence;
    private String creativity;
    private String threat;
    private String ict_index;
}
