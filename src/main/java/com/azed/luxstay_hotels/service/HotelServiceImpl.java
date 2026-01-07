package com.azed.luxstay_hotels.service;

import com.azed.luxstay_hotels.model.Hotel;
import com.azed.luxstay_hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        return hotelRepository.findById(id)
                .map(existingHotel -> {
                    existingHotel.setHotelName(updatedHotel.getHotelName());
                    existingHotel.setAddress(updatedHotel.getAddress());
                    existingHotel.setCity(updatedHotel.getCity());
                    existingHotel.setPhoneNumber(updatedHotel.getPhoneNumber());
                    existingHotel.setEmailAddress(updatedHotel.getEmailAddress());
                    existingHotel.setNbrOfRooms(updatedHotel.getNbrOfRooms());
                    existingHotel.setRating(updatedHotel.getRating());
                    existingHotel.setHotelChain(updatedHotel.getHotelChain());
                    return hotelRepository.save(existingHotel);
                })
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + id));
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
