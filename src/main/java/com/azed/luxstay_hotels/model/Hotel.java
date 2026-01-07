package com.azed.luxstay_hotels.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;

    @Column(nullable = false)
    private String address;

    private String city;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    private Integer nbrOfRooms;

    private Double rating;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Room> rooms;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "hotel_chain_id")
    private HotelChain hotelChain;

}
