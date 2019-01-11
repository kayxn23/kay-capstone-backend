package com.capstonebackend.input;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//@Data applies to the whole GameCreateInput class giving all of its variables getter/setter etc. methods
//@Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
//@Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
@Data
//GameCreatInput is anything that is coming thru in JSON
public class GameCreateInput {
    private String title;
    private String description;
    private Long organizer_id;
    private Long location_id;
    private Date game_date;
}
