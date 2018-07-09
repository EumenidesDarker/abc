package com.example.abc.dao;

import com.example.abc.entity.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    @Ignore
    public void queryPerson() {
        List<Person> personList = personDao.queryPerson();
        assertEquals(3,personList.size());
       /* for (Person p:personList){
            System.out.println(p.getId()+","+p.getName()+","+p.getAge());
        }*/
    }

    @Test
    @Ignore
    public void queryPersonById() {
        Person person = personDao.queryPersonById(1);
        //System.out.println(person.getId()+","+person.getName()+","+person.getAge());
        assertEquals("abc",person.getName());
    }

    @Test
//    @Ignore
    public void insertPerson() {
        Person person = new Person();
        person.setId(4);
        person.setName("baby");
        person.setAge(3);
        int effectedNum=personDao.insertPerson(person);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updatePerson() {
        Person person=new Person();
        person.setId(3);
        person.setName("Angle");
        person.setAge(18);
        int effectedNum=personDao.updatePerson(person);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deletePerson() {
        int effectedNum = personDao.deletePerson(4);
        assertEquals(1,effectedNum);
    }
}