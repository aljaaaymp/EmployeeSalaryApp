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

public class Salaried extends Employee {

	private double weekly_salary;

	public void load () // additional entered values form user, including load method from Employee class
	{
		super.load();
		System.out.println("Salary ==> ");
		double weeklySalary = doubleValidator(weeklySalary = 0);

		this.weekly_salary = weeklySalary;
	}

	public double getEarnings () // calculation for employee that is paid on "Salaried" based
	{
		double salary = this.weekly_salary;
		salary += getBonus();

		checkSalary(salary);

		return salary;
	}

	public double getWeeklySalary()
	{
		return this.weekly_salary;
	}

}
