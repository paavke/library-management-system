package com.library.controllers;

import com.library.dtos.ReservationDTO;
import com.library.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ReservationDTO createReservation(@RequestParam Long memberId, @RequestParam Long bookId) {
        return reservationService.createReservation(memberId, bookId);
    }

    @GetMapping("/member/{memberId}")
    public List<ReservationDTO> getReservationsForMember(@PathVariable Long memberId) {
        return reservationService.getReservationsForMember(memberId);
    }
}
