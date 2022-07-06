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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Scanner;


public abstract class Employee extends SalaryDriver{

	final private int [] monthsArr = {1,2,3,4,5,6,7,8,9,10,11,12};
	final private int [] weeksArr = {1,2,3,4};

	NumberFormat formatter = new DecimalFormat("#0.00");   // setting decimal format into 2 decimal places

	private int birth_month, birth_week;
	private String employee_name, social_security_num ; 

	public Scanner scan = new Scanner(System.in);

	public void load ()  // user loads values for entries
	{
		System.out.print("Name ==> "); 
		String employeeName = scan.nextLine();

		System.out.print("Social Security Number ==> ");	
		String socialSecurityNum = scan.nextLine();

		System.out.print("Birthday month (1-12) ==> ");	
		int birthMonth = validateChoice(monthsArr, birthMonth = 0);

		System.out.print("Birthday bonus week (1-4) ==> "); 
		int birthWeek = validateChoice(weeksArr, birthWeek = 0);

		this.employee_name = employeeName;
		this.social_security_num = socialSecurityNum;
		this.birth_month = birthMonth;
		this.birth_week = birthWeek;
	}

	public  String  toString() // returns the string that will show name, social security number and paycheck
	{
		String salaryString = formatter.format(getEarnings());
		String empDetails = String.format("employee: %s\nsocial security number: %s\npaycheck: $%s",
				this.employee_name, this.social_security_num, salaryString);
		return empDetails;
	}

	public double getBonus ()  // generates additional 100 when entered date is equal to system's date
	{
		final double birthdayBonus = 100;
		double bonus = 0;
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int week =  calendar.get(Calendar.WEEK_OF_MONTH);

		if(month == this.birth_month && week == this.birth_week)
		{
			bonus += birthdayBonus;
		}
		return bonus;
	}

	//check if salary exceeds 1000$
	public double checkSalary(double salary)
	{
		if (salary > 1000)
		{
			salary = 1000;
		}
		return salary;
	}

	public abstract double getEarnings ();
}
