package com.example.abc.dao;

import com.example.abc.entity.Person;

import java.util.List;

public interface PersonDao {
    List<Person> queryPerson();

    Person queryPersonById(int id);

    int insertPerson(Person person);

    int updatePerson(Person person);

    int deletePerson(int id);

}
