package model.services;

public class BrazilTaxService implements TaxService{
	
	//double com d minusculo por que estou considerando
	//que sempre ter� um valor aqui
	

	public double tax(double amount) {

		if(amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
