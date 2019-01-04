package com.capstonebackend.input;

import lombok.Data;

//@Data applies to the whole GameCreateInput class giving all of its variables getter/setter etc. methods
@Data
public class GameCreateInput {
    //datetime, location, organizer
    private String organizer;
//    private Date

}
