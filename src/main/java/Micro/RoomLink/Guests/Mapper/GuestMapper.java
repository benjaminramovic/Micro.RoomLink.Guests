package Micro.RoomLink.Guests.Mapper;

import Micro.RoomLink.Guests.DTO.GuestDTO;
import Micro.RoomLink.Guests.Entity.Guest;

public class GuestMapper {
    public static GuestDTO mapToDTO(Guest guest){
        return new GuestDTO(
                guest.getFirstName(),
                guest.getLastName(),
                guest.getEmail(),
                guest.getDateOfBirth()
        );
    }
    public static Guest mapToGuest(GuestDTO guestDTO){
        return new Guest(
            null,
                guestDTO.getFirstName(),
                guestDTO.getLastName(),
                guestDTO.getEmail(),
                guestDTO.getDateOfBirth()
        );
    }
}
