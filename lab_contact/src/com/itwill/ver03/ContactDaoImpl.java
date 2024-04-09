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

	public List<Contact> contacts = new ArrayList<Contact>();

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}

	@Override
	public int create(Contact contact) {
		contacts.add(contact);
		return 1;
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;
		}

	}

	@Override
	public int update(int index, Contact contact) {
		if ((isValidIndex(index))) {
			contacts.set(index, contact);
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int delete(int index) {
		if ((isValidIndex(index))) {
			contacts.remove(index);
			return 1;
		} else {
			return 0;
		}

	}

}
