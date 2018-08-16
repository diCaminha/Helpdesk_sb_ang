package com.dnc.projs.helpdesk.dnchelpdesk.domain.enums;

import com.sun.org.apache.bcel.internal.generic.NEW;

public enum StatusEnum {
	NEW,
	ASSIGNED,
	APPROVED,
	DISAPPROVED,
	CLOSED;

	public static StatusEnum getStatus(String statusStr){

		switch (statusStr) {
			case "New" : return NEW;
			case "Assigned" : return ASSIGNED;
			case "Approved" : return APPROVED;
			case "Disapproved" : return DISAPPROVED;
			case "Closed" : return CLOSED;
			default : return NEW;
		}
	}
}
