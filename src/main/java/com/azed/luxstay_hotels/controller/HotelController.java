package com.azed.luxstay_hotels.controller;

import com.azed.luxstay_hotels.model.Hotel;
import com.azed.luxstay_hotels.service.HotelService;
import com.azed.luxstay_hotels.service.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;
    private final HotelChainService hotelChainService;

    @Autowired
    public HotelController(HotelService hotelService, HotelChainService hotelChainService) {
        this.hotelService = hotelService;
        this.hotelChainService = hotelChainService;
    }

    @GetMapping
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAllHotels());
        return "hotelsEmployeeList";
    }

    @GetMapping("/customer")
    public String listHotelsForCustomers(Model model) {
        model.addAttribute("hotels", hotelService.findAllHotels());
        return "hotelsCustomerList";
    }

    @GetMapping("/chain/{chainId}")
    public String listHotelsByChain(@PathVariable Long chainId, Model model) {
        model.addAttribute("hotels", hotelService.findAllHotels().stream()
                .filter(hotel -> hotel.getHotelChain() != null && hotel.getHotelChain().getHotelChainId().equals(chainId))
                .toList());
        return "hotelsEmployeeList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("hotelChains", hotelChainService.findAllHotelChains());
        return "addHotel";
    }

    @PostMapping
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return hotelService.findHotelById(id).map(hotel -> {
            model.addAttribute("hotel", hotel);
            model.addAttribute("hotelChains", hotelChainService.findAllHotelChains());
            return "hotel/edit";
        }).orElse("redirect:/hotels");
    }

    @PostMapping("/update")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.updateHotel(hotel.getHotelId(), hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotels";
    }
}
