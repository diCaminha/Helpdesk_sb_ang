package com.dnc.projs.helpdesk.dnchelpdesk.service.Impl;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.ChangeStatus;
import com.dnc.projs.helpdesk.dnchelpdesk.domain.Ticket;
import com.dnc.projs.helpdesk.dnchelpdesk.repository.ChangeStatusRepository;
import com.dnc.projs.helpdesk.dnchelpdesk.repository.TicketRepository;
import com.dnc.projs.helpdesk.dnchelpdesk.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ChangeStatusRepository changeStatusRepository;

    @Override
    public Ticket createOrUpdate(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(String id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        this.ticketRepository.deleteById();
    }

    @Override
    public Page<Ticket> listTicket(int page, int count) {
        Pageable pageable = new PageRequest(page,count);
        return this.ticketRepository.findAll(pageable);
    }

    @Override
    public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
        return this.changeStatusRepository.save(changeStatus);
    }

    @Override
    public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
        return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
    }

    @Override
    public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
        return this.ticketRepository.findByUserIdOrderByDateDesc(new PageRequest(page,count),userId);
    }

    @Override
    public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
        return this.ticketRepository.findByTitleAndStatusAndPriority(new PageRequest(page,count), title, status, priority);
    }

    @Override
    public Page<Ticket> findByParametersByUser(int page, int count, String title, String status, String priority, String userId) {
        return this.ticketRepository.findByTitleAndStatusAndPriorityAndUserId(new PageRequest(page,count), title, status, priority, userId);
    }

    @Override
    public Page<Ticket> findByParametersByAssignedUser(int page, int count, String title, String status, String priority, String assignedUserId) {
        return this.ticketRepository.findByTitleAndStatusAndPriorityAndAssignedUserId(new PageRequest(page,count), title, status, priority, assignedUserId);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return this.ticketRepository.findAll();
    }
}
