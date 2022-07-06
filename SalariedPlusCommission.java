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

public class SalariedPlusCommission extends Salaried {

	double  past_week_sales;
	double commission_rate;

	public void load () // additional entered values from user, including load method from Salaried class
	{
		super.load();
		System.out.println("Sales for this past week ==> ");
		double salesDuringThePastWeek = doubleValidator(salesDuringThePastWeek = 0);

		System.out.println("Sales commission rate (fraction paid to employee) ==> ");
		double commissionRate = doubleValidator(commissionRate = 0);

		this.past_week_sales = salesDuringThePastWeek;
		this.commission_rate = commissionRate;
	}

	public double getEarnings () // calculation for employee that is paid on "Salaried plus commission" based
	{
		double percentageOfSale = this.past_week_sales * this.commission_rate;
		double salary = percentageOfSale + super.getWeeklySalary();
		salary += getBonus();

		checkSalary(salary);

		return salary;
	}
}
