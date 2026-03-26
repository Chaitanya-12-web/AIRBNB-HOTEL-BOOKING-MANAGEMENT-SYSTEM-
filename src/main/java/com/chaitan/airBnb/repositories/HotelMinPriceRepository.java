package com.chaitan.airBnb.repositories;

import com.chaitan.airBnb.dtos.HotelPriceDto;
import com.chaitan.airBnb.entity.Hotel;
import com.chaitan.airBnb.entity.HotelMinPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface HotelMinPriceRepository extends JpaRepository<HotelMinPrice, Long> {

    @Query("""
     SELECT new com.chaitan.airBnb.dtos.HotelPriceDto(i.hotel, AVG(i.price))
      FROM HotelMinPrice i
       WHERE i.hotel.city = :city
         AND i.date BETWEEN :startDate AND :endDate
         AND i.hotel.active = true
         AND i.availableRooms >= :roomsCount
     GROUP BY i.hotel
    HAVING COUNT(i.date) = :dateCount
  """)
    Page<HotelPriceDto> findHotelsWithAvailableInventory(
            @Param("city") String city,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("roomsCount") Integer roomsCount,
            @Param("dateCount") Long dateCount,
            Pageable pageable
    );

    Optional<HotelMinPrice> findByHotelAndDate(Hotel hotel, LocalDate date);
}
