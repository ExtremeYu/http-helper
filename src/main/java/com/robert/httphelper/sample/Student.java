package com.robert.httphelper.sample;

/**
 * <p>
 * Beans for samples.
 * </p>
 *
 * @author Robert Lee
 * @version 1.0
 * @since Jul 15, 2015
 */

public class Student {
	private String name;
	private int years;

	public Student() {

	}

	public Student(String name, int years) {
		this.name = name;
		this.years = years;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Student) obj).name.equals(name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Student[");
		sb.append("name=").append(name).append(",");
		sb.append("years").append(years);
		sb.append("]");

		return super.toString();
	}
}