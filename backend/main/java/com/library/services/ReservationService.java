package com.library.services;

import com.library.dtos.ReservationDTO;
import com.library.entities.Reservation;
import com.library.repositories.ReservationRepository;
import com.library.repositories.MemberRepository;
import com.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    public ReservationDTO createReservation(Long memberId, Long bookId) {
        Reservation reservation = new Reservation();
        reservation.setMember(memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found")));
        reservation.setBook(bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found")));
        reservation.setReservationDate(LocalDate.now());
        reservation.setExpirationDate(LocalDate.now().plusDays(14)); // Example expiration of 14 days
        reservation.setFulfilled(false);
        Reservation savedReservation = reservationRepository.save(reservation);
        return mapToDTO(savedReservation);
    }

    public List<ReservationDTO> getReservationsForMember(Long memberId) {
        return reservationRepository.findByMemberId(memberId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ReservationDTO mapToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setMemberId(reservation.getMember().getId());
        dto.setBookId(reservation.getBook().getId());
        dto.setReservationDate(reservation.getReservationDate().toString());
        dto.setExpirationDate(reservation.getExpirationDate().toString());
        dto.setFulfilled(reservation.isFulfilled());
        return dto;
    }
}
