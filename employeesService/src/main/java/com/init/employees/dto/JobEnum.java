package com.init.employees.dto;

public enum JobEnum {

	JEFE(3000), TRABAJADOR(1000);

	private int salary;

	// Añadir un constructor
	JobEnum(int s) {
		salary = s;
	}

	// Añadir un método
	int getSalary() {
		return salary;
	}

}
