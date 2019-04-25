package model.entities;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish; 
	//associa��es
	private Vehicle vehicle;
	private Invoice invoice;
		
	public CarRental() {
	}

	//o invoice n�o  entra no construtor, por que o meu aluguel pode n�o ter processado a nota de pagamento
	public CarRental(Date start, Date finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}


	
	
	
}
