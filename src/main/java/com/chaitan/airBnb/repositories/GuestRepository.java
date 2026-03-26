package com.chaitan.airBnb.repositories;


import com.chaitan.airBnb.entity.Guest;
import com.chaitan.airBnb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);
}