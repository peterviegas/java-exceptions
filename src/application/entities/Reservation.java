package application.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = ChronoUnit.DAYS.between(checkIn, checkOut);
		return diff;		
	}
	
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates or updates musst be future";
		}
		
		if (!checkOut.isAfter(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
		
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", checkIn: "
				+ dtf.format(checkIn)
				+ ", checkout: "
				+ dtf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
