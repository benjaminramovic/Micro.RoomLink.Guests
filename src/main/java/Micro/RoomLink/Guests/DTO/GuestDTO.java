package Micro.RoomLink.Guests.DTO;

import lombok.*;

import java.util.Date;


@Setter
@Builder
@NoArgsConstructor

public class GuestDTO {
    private String firstName;  // Promenjena imena polja u camelCase
    private String lastName;   // Promenjena imena polja u camelCase
    private String email;
    private Date dateOfBirth;


    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public Date getDateOfBirth(){return dateOfBirth;}

    public GuestDTO(String firstName, String lastName, String email, Date dateOfBirth){
        this.firstName= firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

}
