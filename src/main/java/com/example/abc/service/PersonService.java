package com.example.abc.service;

import com.example.abc.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList();

    Person getPersonById(int id);

    boolean addPerson(Person person);

    boolean modifyPerson(Person person);

    boolean deletePerson(int id);

}
