package Micro.RoomLink.Guests.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@Setter
@Builder

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Promenjena imena polja u camelCase
    private String firstName; // Promenjena imena polja u camelCase
    private String lastName;  // Promenjena imena polja u camelCase
    private String email;
    private Date dateOfBirth;

    public Long getId(){return id;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public Date getDateOfBirth(){return dateOfBirth;}

    public void setFirstName(String value){firstName = value;}
    public void setLastName(String value){lastName = value;}
    public void setEmail(String value){email = value;}
    public void setDateOfBirth(Date value){dateOfBirth = value;}



    public Guest(){

    }
    public Guest(Long id, String firstName, String lastName, String email, Date dateOfBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
