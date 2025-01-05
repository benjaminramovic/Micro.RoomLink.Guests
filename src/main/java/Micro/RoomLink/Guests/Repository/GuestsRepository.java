package Micro.RoomLink.Guests.Repository;

import Micro.RoomLink.Guests.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestsRepository extends JpaRepository<Guest,Long> {
}
