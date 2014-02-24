package ru.ncideas.magazinof.api.domain;

import java.util.List;

/**
 * User: mbragin
 * Date: 28.04.12
 * Time: 18:20
 */
public class UserList {

	private int count;
	private List<User> users;

	public UserList() {}

	public UserList(List<User> users) {
		this.users = users;
		this.count = users.size();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<User> getEmployees() {
		return users;
	}
	public void setEmployees(List<User> users) {
		this.users = users;
	}

}
