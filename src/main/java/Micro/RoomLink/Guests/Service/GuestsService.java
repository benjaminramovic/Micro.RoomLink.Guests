package Micro.RoomLink.Guests.Service;

import Micro.RoomLink.Guests.DTO.GuestDTO;
import Micro.RoomLink.Guests.Entity.Guest;
import Micro.RoomLink.Guests.Exception.NotFoundException;
import Micro.RoomLink.Guests.Mapper.GuestMapper;
import Micro.RoomLink.Guests.Repository.GuestsRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestsService implements IGuestsService{

    GuestsRepository repository;

    public GuestsService(GuestsRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Guest> getAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public GuestDTO getById(Long id) {
        Guest guest = repository.findById(id).orElseThrow(()->
                new NotFoundException("Gost nije pronadjen!")
                );
        return GuestMapper.mapToDTO(guest);
    }

    @Override
    public GuestDTO addGuest(GuestDTO guestDTO) {
        Guest guest = GuestMapper.mapToGuest(guestDTO);
        return GuestMapper.mapToDTO(repository.save(guest));
    }

    @Override
    public void delete(Long id) {
       Guest guest = repository.findById(id).orElseThrow(()->
               new NotFoundException("Gost nije pronadjen!")
       );
       repository.deleteById(id);
    }

    @Override
    public GuestDTO update(Long id, GuestDTO newGuest) {
        Guest guest = repository.findById(id).orElseThrow(()->
            new NotFoundException("Gost nije pronadjen!")
        );
        guest.setFirstName(newGuest.getFirstName());
        guest.setLastName(newGuest.getLastName());
        guest.setEmail(newGuest.getEmail());
        guest.setDateOfBirth(newGuest.getDateOfBirth());

        return GuestMapper.mapToDTO(repository.save(guest));


    }
}
