package Micro.RoomLink.Guests.Controller;

import Micro.RoomLink.Guests.DTO.GuestDTO;
import Micro.RoomLink.Guests.Entity.Guest;
import Micro.RoomLink.Guests.Service.IGuestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private IGuestsService service;

    public GuestController(IGuestsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<GuestDTO> addGuest(@RequestBody GuestDTO guest){
        return ResponseEntity.ok(service.addGuest(guest));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Gost je uspesno izbrisan!");
    }
    @GetMapping("{id}")
    public ResponseEntity<GuestDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<GuestDTO> update(@PathVariable Long id, @RequestBody GuestDTO guest){
        return ResponseEntity.ok(service.update(id,guest));
    }

}
