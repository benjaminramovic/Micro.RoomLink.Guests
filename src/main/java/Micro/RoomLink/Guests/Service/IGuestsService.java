package Micro.RoomLink.Guests.Service;

import Micro.RoomLink.Guests.DTO.GuestDTO;
import Micro.RoomLink.Guests.Entity.Guest;

import java.util.List;

public interface IGuestsService {
    List<Guest> getAll();
    GuestDTO getById(Long id);
    GuestDTO addGuest(GuestDTO guestDTO);
    void delete(Long id);
    GuestDTO update(Long id, GuestDTO newGuest);
}
