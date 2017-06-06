package com.fbart.eshop.loveshopping.model.nosql;

import java.io.Serializable;

public class PersonN implements Serializable {
	private static final long serialVersionUID = 8351376758720046362L;
	private String id;
	private String name;
	private int age;

	public PersonN() {
		super();
	}

	public PersonN(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 * @param name
	 * @param age
	 */
	public PersonN(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "PersonN[id=" + id + ",name=" + name + ",age=" + age + "]";
	}
}
