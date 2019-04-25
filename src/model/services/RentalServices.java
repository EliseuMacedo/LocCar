package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {

	private Double pricePerHour;
	private Double pricePerDay;
	// associação
	private TaxService taxService;

	// alguns frameworks exigem o construtor padrão nas entidades
	public RentalServices() {
	}

	public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

 	public void processInVoice(CarRental carRental) {

		// preciso armazenar os valores em millisegundos para o calculo.
		// valor em millisegundos
		long t = carRental.getFinish().getTime() - carRental.getStart().getTime();
		// vou receber num double a diferença em horas
		double hours = (double) t / 1000 / 60 / 60; // transformei em segundos>>minutos>>horas
		double basicPayment;
		
		if (hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		} 
		else {
			basicPayment = Math.ceil(hours/24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		
		//instanciar o meu objeto invoice
		carRental.setInvoice(new Invoice(basicPayment, tax));

	}
}
