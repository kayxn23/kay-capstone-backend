package com.capstonebackend.input;

import lombok.Data;

@Data
public class PlayerCreateInput {
    private String first_name;
    private String user_name;
    private Integer games_played;
}
