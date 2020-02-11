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
public class Player {

    @Id
    private long id;

    private float code;
    private float element_type;
    private String ep_next;
    private String ep_this;
    private float event_points;
    private String first_name;
    private String form;
    private String news;
    private float now_cost;
    private String photo;
    private String points_per_game;
    private String second_name;
    private boolean special;
    private String squad_number = null;
    private String status;
    private float team;
    private float team_code;
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
