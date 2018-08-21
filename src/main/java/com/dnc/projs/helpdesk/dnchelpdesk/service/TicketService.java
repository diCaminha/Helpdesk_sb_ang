package com.dnc.projs.helpdesk.dnchelpdesk.service;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.ChangeStatus;
import com.dnc.projs.helpdesk.dnchelpdesk.domain.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface TicketService {

    Ticket createOrUpdate(Ticket ticket);

    Optional<Ticket> findById(String id);

    void delete(String id);

    Page<Ticket> listTicket(int page, int count);

    ChangeStatus createChangeStatus(ChangeStatus changeStatus);

    Iterable<ChangeStatus> listChangeStatus(String ticketId);

    Page<Ticket> findByCurrentUser(int page, int count, String userId);

    Page<Ticket> findByParameters(int page, int count, String title, String status, String priority);

    Page<Ticket> findByParametersByUser(int page, int count, String title, String status, String priority, String userId);

    Page<Ticket> findByParametersByAssignedUser(int page, int count, String title, String status, String priority, String assignedUserId);

    Iterable<Ticket> findAll();


}
