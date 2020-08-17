package entities;

public class Individual extends TaxPayer {
	private Double healthExpenses;
	
	public Individual() {
			super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}
	
	public Double getHelthExpenses() {
		return healthExpenses;
	}
	
	public void setHelthExpenses(double healthExpenses ) {
		this.healthExpenses = healthExpenses;
		
	}
	
	
	@Override
	public Double tax() {
		if (getAnualIncome() < 20000) {
			return getAnualIncome()*0.15 - 0.5* healthExpenses;
		}else {
			return getAnualIncome()*0.25 - 0.5* healthExpenses;
		}
	}
	
	
}
