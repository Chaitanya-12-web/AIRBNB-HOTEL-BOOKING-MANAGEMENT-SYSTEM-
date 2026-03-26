package com.chaitan.airBnb.services;

import com.chaitan.airBnb.dtos.HotelPriceResponseDto;
import com.chaitan.airBnb.dtos.HotelSearchRequest;
import com.chaitan.airBnb.dtos.InventoryDto;
import com.chaitan.airBnb.dtos.UpdateInventoryRequestDto;
import com.chaitan.airBnb.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
