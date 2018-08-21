package com.dnc.projs.helpdesk.dnchelpdesk.repository;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.Ticket;
import com.dnc.projs.helpdesk.dnchelpdesk.domain.enums.PriorityEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket,String> {

	void deleteById();

	Page<Ticket> findByAuthorUserIdOrderByDateDesc(String authorUserId);

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pageable, String userId);

	Page<Ticket> findByTitleAndStatusAndPriority(Pageable pageable, String title, String status, String priority);

	Page<Ticket> findByTitleAndStatusAndPriorityAndUserId(PageRequest pageRequest, String title, String status, String priority, String userId);

	Page<Ticket> findByTitleAndStatusAndPriorityAndAssignedUserId(PageRequest pageRequest, String title, String status, String priority, String assignedUserId);
}
