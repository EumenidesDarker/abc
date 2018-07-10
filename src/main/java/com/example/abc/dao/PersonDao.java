package com.example.abc.dao;

import com.example.abc.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonDao {

    /*查询数据库中所有记录*/
    @Select("select * from test")
    List<Person> queryPerson();

    /*根据id查询记录 */
    @Select("select * from test where id=#{id}")
    Person queryPersonById(@Param("id") int id);

    /*插入一条记录*/
    @Insert("insert into test(id,name,age) values(#{id},#{name},#{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertPerson(Person person);

    /*更新一条记录*/
    @Update("update test set name=#{name},age=#{age} where id=#{id}")
    int updatePerson(Person person);

    /*根据id删除一条记录*/
    @Delete("delete from test where id=#{id}")
    int deletePerson(@Param("id") int id);

}
