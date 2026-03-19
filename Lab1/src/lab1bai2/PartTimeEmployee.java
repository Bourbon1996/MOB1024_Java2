package lab1bai2;

public class PartTimeEmployee extends Employee {

		private double workingHours;
		private double hourlyRate;
		
		
		public PartTimeEmployee(String id, String name, double basicSalaray, double workingHours, double hourlyRate) {
			super(id, name, basicSalaray);
			this.workingHours = workingHours;
			this.hourlyRate = hourlyRate;
		}
		
		public double getWorkingHours() {
			return this.workingHours;					
		}
		
		public boolean setWorkingHours(double workingHours) {
			if(workingHours >= 0) {
				this.workingHours = workingHours;
				return true;
			}return false;
		}	
		public double getHourlyRate() {
			return this.hourlyRate;
		}
		
		public boolean sethourslyRate(double hourlyRate) {
			if(hourlyRate >=0) {
				this.hourlyRate = hourlyRate;
				return true;
			} return false;
		}
	
		
	@Override
	public double income() {
		return this.workingHours * this.hourlyRate;
	}

	@Override
	public String toString() {
		return super.toString() +  "PartTimeEmployee [workingHours=" + workingHours + ", hourlyRate=" + hourlyRate + "]";
	}
	
	
	
}
