package com.example.homework09.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movie {

    @Id
    @NotNull(message = "id can't be empty")
    @Size(min = 3,message = "id has to be at least 3 characters")
    @Column(unique = true)
    private String id;
    @NotEmpty(message = "name can't be empty")
    @Size(min = 2,message = "name has to be at least 2 characters")
    @Column(unique = true)
    private String name;
    @NotEmpty(message = "genre can't be empty")
    @Pattern(regexp = "(Drama|Action|Comedy)",message = "genre can only be drama , action or comedy")
    @Column(nullable = false)
    private String genre;
    @NotNull(message = "rating can't be null")
    @Min(value = 1,message = "rating has to be between 1 and 5")
    @Max(value = 5,message = "rating can be a maximum of 5")
    private Integer rating;
    @NotNull(message = "duration can't be null")
    @Min(value = 60,message = "duration has to be more than 60")
    private Integer duration;
    @NotNull(message = "launch date can't be null")
    @Pattern(regexp = "/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/",message = "Launch date has to be in the format yyyy-mm-dd")
    private LocalDate launchDate;


}
