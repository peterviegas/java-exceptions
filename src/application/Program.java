package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import application.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		
		System.out.println("Check-in date (dd/mm/yyyy)");
		LocalDate checkin = LocalDate.parse(sc.next(),dtf);
		
		System.out.println("Check-out date (dd/mm/yyyy)");
		LocalDate checkout = LocalDate.parse(sc.next(),dtf);
		
		if (!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation =  new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/mm/yyyy)");
			checkin = LocalDate.parse(sc.next(),dtf);
			
			System.out.println("Check-out date (dd/mm/yyyy)");
			checkout = LocalDate.parse(sc.next(),dtf);
			
			LocalDate now = LocalDate.now();
			
			if (checkin.isBefore(now) || checkout.isBefore(now)) {
				System.out.println("Error in reservation. Reservation dates or updates musst be future");
			}else {
				if (!checkout.isAfter(checkin)) {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}else {
					reservation.updateDates(checkin, checkout);					
					System.out.println("Reservation: " + reservation);
				}
			}
			
			
			
		}
			
		
		sc.close();
	}

}
