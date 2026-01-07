package com.azed.luxstay_hotels.service;

import com.azed.luxstay_hotels.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<Hotel> findAllHotels();

    Optional<Hotel> findHotelById(Long id);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(Long id, Hotel updatedHotel);

    void deleteHotel(Long id);
}

