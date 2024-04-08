package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance;

	private ContactDaoImpl() {
	}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	ArrayList<Contact> contacts = new ArrayList<Contact>();

	private int count = 0;

	@Override
	public int create(Contact contact) {
		if (contacts.add(contact)) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {

		return contacts.get(index);

	}

	@Override
	public int update(int index, Contact contact) {

		contacts.set(index, contact);
		return 1;

	}

	@Override
	public int delete(int index) {

		contacts.remove(index);
		return 1;

	}

}
