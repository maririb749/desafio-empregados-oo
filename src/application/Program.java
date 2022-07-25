package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento:");
		String deptName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefona: ");
		String phone = sc.next();

		Address address = new Address(email, phone);
		Department dept = new Department(deptName, payDay, address);

		System.out.print("Quantos funcion�rios tem o departamento? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do funcion�rio" + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Salario: ");
			double salary = sc.nextDouble();

			Employee emp = new Employee(employeeName, salary);
			dept.addEmployee(emp);

		}
		
		System.out.println();
		showReport(dept);

		sc.close();

	}

	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.printf("Departamento %s =  R$ %.2f%n", dept.getName(), dept.payroll());
		System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
		System.out.println("Funcion�rios: ");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		
		System.out.println("Para d�vidas favor entrar em contato: vendas@lojatop.com");
		
		
		
	}

}
