package com.example.abc.dao;

import com.example.abc.entity.Person;

import java.util.List;

public interface PersonDao {

    /*查询数据库中所有记录*/
    List<Person> queryPerson();

    /*根据id查询记录 */
    Person queryPersonById(int id);

    /*插入一条记录*/
    int insertPerson(Person person);

    /*更新一条记录*/
    int updatePerson(Person person);

    /*根据id删除一条记录*/
    int deletePerson(int id);

}
