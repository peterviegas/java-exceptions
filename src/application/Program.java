package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			
			System.out.println("Check-in date (dd/mm/yyyy)");
			LocalDate checkin = LocalDate.parse(sc.next(),dtf);
			
			System.out.println("Check-out date (dd/mm/yyyy)");
			LocalDate checkout = LocalDate.parse(sc.next(),dtf);
			
			Reservation reservation =  new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/mm/yyyy)");
			checkin = LocalDate.parse(sc.next(),dtf);
			
			System.out.println("Check-out date (dd/mm/yyyy)");
			checkout = LocalDate.parse(sc.next(),dtf);
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
