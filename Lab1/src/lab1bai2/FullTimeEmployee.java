package lab1bai2;

public class FullTimeEmployee extends Employee{
	
	private double bonus;
	private double penalty;
	

	public FullTimeEmployee(String id, String name, double basicSalaray, double bonus, double penalty) {
		
		super(id, name, basicSalaray);
		this.bonus = bonus;
		this.penalty = penalty;
	}
	
	public double getBonus() {
		return this.bonus;
		
	}
	
	public boolean setbonus(double bonus) {
		if(bonus >= 0) {
			this.bonus = bonus;
			return true;
		}return false;	
	}
	
	public double getPenalty() {
		return this.penalty;
		
	}
	
	public boolean setpenalty(double penalty) {
		if(penalty >= 0) {
			this.penalty = penalty;
			return true;
		}return false;
	}
	
	
	@Override
	public double income() {
		return super.getBasicSalaray() + this.bonus - this.penalty;
	}

	@Override
	public String toString() {
		return super.toString() + "FullTimeEmployee [bonus=" + bonus + ", penalty=" + penalty + "]";
	}
	
	
}
	
	
