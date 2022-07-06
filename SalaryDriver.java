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

import java.util.*;

public class SalaryDriver {

	static Scanner scan = new Scanner (System.in);

	public static void main(String[] args) {

		int [] empTypeArr = {1,2,3};

		int numberOfEmployee, typeOfEmployee = 0;
		System.out.println("Number of employees: ");
		numberOfEmployee = intValidator(numberOfEmployee = 0);

		Employee[] employeeArr = new Employee[numberOfEmployee]; // Array list that will store the Employee's data

		for (int index = 0; index < numberOfEmployee; index++) // loop depending on the number of employees that user input
		{
			System.out.println("PROFILE FOR EMPLOYEE #" + (index +1));
			System.out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3) ");
			System.out.println("Enter 1, 2, or 3 ==> ");
			typeOfEmployee = validateChoice(empTypeArr, typeOfEmployee);

			// choices from 1-3 which type of employees will input values, initiating object class and calling load method
			if (typeOfEmployee == 1)
			{
				employeeArr[index] = new Hourly();
				employeeArr[index].load();
			}

			if (typeOfEmployee == 2)
			{
				employeeArr[index] = new Salaried();
				employeeArr[index].load();
			}

			if (typeOfEmployee == 3)
			{
				employeeArr[index] = new SalariedPlusCommission();
				employeeArr[index].load();
			}	
		}
		// loop depending on the number of employees, and calling toString method
		for (int index = 0; index < numberOfEmployee; index++) {
			System.out.println("\n" + employeeArr[index].toString());
		}
		scan.close();
	}
	// validation for choices ( 1, 2 and 3) data input by the user
	public static int validateChoice(int[] numArr,int choiceInt)
	{
		Boolean choiceMatch = false;
		do{
			choiceInt = intValidator(choiceInt);
			for(int index = 0; index < numArr.length; index++){
				if(choiceInt == numArr[index]){
					choiceMatch = true;
				}
			}
			if(choiceMatch == false){
				System.out.println("Input out of range. Please try again.");
			}

		}while(!choiceMatch);

		return choiceInt;
	}

	//validation double data input by the user
	public static double doubleValidator(double num){
		boolean invalid;
		do{
			try{
				num = scan.nextDouble();
				invalid = false;
			} catch(InputMismatchException e){
				scan.nextLine();
				System.out.println("Invalid Input");
				invalid = true;
			}
		}while(invalid == true);
		return num;
	}

	//validation int data input by the user
	public static int intValidator(int num){
		boolean invalid;
		do{
			try{
				num = scan.nextInt();
				invalid = false;
			} catch(InputMismatchException e){
				scan.nextLine();
				System.out.println("Invalid Input");
				invalid = true;
			}
		}while(invalid == true);
		return num;
	}
}
