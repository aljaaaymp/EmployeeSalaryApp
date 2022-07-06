/**
* Java Course 3, Module 1
* 
* Assignment 1: Inheritance and Polymorphism
* 
* Payroll program  that uses polymorphism to calculate and print the weekly payroll for company
* 
* @author Aljay Pascual
*/
package graded;

public class Hourly extends Employee {

	private double hourly_pay, hours_worked;

	public void load() // additional entered values form user, including load method from Employee
						// class
	{
		super.load();
		System.out.print("Hourly Pay ==> ");
		double hourlyPay = doubleValidator(hourlyPay = 0);

		System.out.print("Hours worked this past week ==> ");
		double hoursWorked = doubleValidator(hoursWorked = 0);

		this.hourly_pay = hourlyPay;
		this.hours_worked = hoursWorked;
	}

	public double getEarnings() // calculation for employee that is paid on "hourly" based
	{
		double salary = this.hourly_pay * this.hours_worked;
		if (this.hours_worked > 40) {
			double overTime = (1 / 2 * this.hourly_pay);
			salary += overTime;
		}

		salary += getBonus();

		checkSalary(salary);

		return salary;
	}
}
