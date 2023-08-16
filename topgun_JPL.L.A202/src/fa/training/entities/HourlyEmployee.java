package fa.training.entities;

public class HourlyEmployee extends Employee {
	private double rate;
	private double workingHours;

	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			double rate, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		this.rate = rate;
		this.workingHours = workingHours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public double calculatePay() {
		return rate * workingHours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee{" + "ssn='" + getSsn() + '\'' + ", firstName='" + getFirstName() + '\'' + ", lastName='"
				+ getLastName() + '\'' + ", birthDate='" + getBirthDate() + '\'' + ", phone='" + getPhone() + '\''
				+ ", email='" + getEmail() + '\'' + ", rate=" + rate + ", workingHours=" + workingHours + '}';
	}
}
