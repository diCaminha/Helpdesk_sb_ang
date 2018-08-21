package com.dnc.projs.helpdesk.dnchelpdesk.service.Impl;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.ChangeStatus;
import com.dnc.projs.helpdesk.dnchelpdesk.domain.Ticket;
import com.dnc.projs.helpdesk.dnchelpdesk.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public Ticket createOrUpdate(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Page<Ticket> listTicket(int page, int count) {
        return null;
    }

    @Override
    public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
        return null;
    }

    @Override
    public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
        return null;
    }

    @Override
    public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
        return null;
    }

    @Override
    public Page<Ticket> findByParametersByUser(int page, int count, String title, String status, String priority, String userId) {
        return null;
    }

    @Override
    public Page<Ticket> findByParametersByAssignedUser(int page, int count, String title, String status, String priority, String assignedUserId) {
        return null;
    }

    @Override
    public Iterable<Ticket> findAll() {
        return null;
    }
}
