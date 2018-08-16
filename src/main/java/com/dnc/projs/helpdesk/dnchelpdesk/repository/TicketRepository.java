package com.dnc.projs.helpdesk.dnchelpdesk.repository;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket,String> {

	Page<Ticket> findByAuthorUserIdOrderByDateDesc(String authorUserId);

}
