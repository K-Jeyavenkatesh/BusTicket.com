package service;

import model.Ticket;

public interface TicketDao {

	public long addTicket(Ticket ticket);
	public Ticket getTicket(String pnr);
}
