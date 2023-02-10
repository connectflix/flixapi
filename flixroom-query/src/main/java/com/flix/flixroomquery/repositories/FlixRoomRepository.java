package com.flix.flixroomquery.repositories;

import com.flix.flixroomquery.entities.FlixRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlixRoomRepository extends JpaRepository<FlixRoom, String> {

}
