package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.RentalServices;
import model.services.BrazilTaxService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);
		
		//dados
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		//Instanciamos o objeto do carro
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalServices rs = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxService());
		//chamar a função abaixo passando como argumento o objeto carRental = cr para instanciar 
		// a classe de dominio Invoice
		rs.processInVoice(cr);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f" , cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f" , cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f" , cr.getInvoice().getTotalPayment()));
		
		

	}

}
