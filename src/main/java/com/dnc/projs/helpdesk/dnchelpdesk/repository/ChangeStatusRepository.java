package com.dnc.projs.helpdesk.dnchelpdesk.repository;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.ChangeStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus,String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
