package com.demo.async.model;

public class EmployeeData {
	private EmployeeAddresses employeeAddresses;
	private EmployeeNames employeeNames;
	private EmployeePhone employeePhone;
	
	public EmployeeData() {
		
	}
	
	public EmployeeData(EmployeeAddresses employeeAddresses, EmployeeNames employeeNames, EmployeePhone employeePhone ) {
		this.employeeAddresses = employeeAddresses;
		this.employeeNames = employeeNames;
		this.employeePhone = employeePhone;
		
	}

	public EmployeeAddresses getEmployeeAddresses() {
		return employeeAddresses;
	}

	public void setEmployeeAddresses(EmployeeAddresses employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	public EmployeeNames getEmployeeNames() {
		return employeeNames;
	}

	public void setEmployeeNames(EmployeeNames employeeNames) {
		this.employeeNames = employeeNames;
	}

	public EmployeePhone getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(EmployeePhone employeePhone) {
		this.employeePhone = employeePhone;
	}

}
