package ua.edu.ucu.flowerstore.appuser;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Getter @Setter
public class AppUser {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    @Transient
    private int age;
    private LocalDate dob;


    public int getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }



}
