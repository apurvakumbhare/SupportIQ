package com.example.SupportIQ.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupportIQ.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

   // Optional<Ticket> findByTicketId(Long ticketId);
    Optional<Ticket> findByEmail(String email);



}