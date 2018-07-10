package com.example.abc.service.impl;

import com.example.abc.dao.PersonDao;
import com.example.abc.entity.Person;
import com.example.abc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> getPersonList() {
        return personDao.queryPerson();
    }

    @Override
    public Person getPersonById(int id) {
        Person person = personDao.queryPersonById(id);
        if (person != null) {
            return person;
        } else {
            throw new RuntimeException("查无此人！");
        }


    }

    @Transactional
    @Override
    public boolean addPerson(Person person) {
        if (person.getName() != null && !"".equals(person.getName())) {
            try {
                int effectedNum = personDao.insertPerson(person);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入个人信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入个人信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("个人姓名不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyPerson(Person person) {
        if (person.getId() != null && person.getId() > 0) {
            try {
                int effectedNum = personDao.updatePerson(person);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新个人信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新个人信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("个人信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deletePerson(int id) {
        if (id > 0) {
            try {
                int effectedNum = personDao.deletePerson(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除个人信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除个人信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("个人id不能为空！");
        }
    }
}
