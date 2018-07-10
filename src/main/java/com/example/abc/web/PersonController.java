package com.example.abc.web;

import com.example.abc.entity.Person;
import com.example.abc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/listperson", method = RequestMethod.GET)
    private Map<String, Object> listPerson() {
        Map<String, Object> modelMap = new HashMap<>();
//      列出所有个人信息
        List<Person> list = personService.getPersonList();
        modelMap.put("personList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getpersonbyid", method = RequestMethod.GET)
    private Map<String, Object> getPersonById(Integer id) {
        Map<String, Object> modelMap = new HashMap<>();
//        根据id查询个人信息
        Person person = personService.getPersonById(id);
        modelMap.put("person", person);
        return modelMap;
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.POST)
    private Map<String, Object> addPerson(@RequestBody Person person) {
        Map<String, Object> modelMap = new HashMap<>();
//        插入个人信息
        modelMap.put("success", personService.addPerson(person));
        return modelMap;
    }

    @RequestMapping(value = "/modifyperson", method = RequestMethod.POST)
    private Map<String, Object> modifyPerson(@RequestBody Person person) {
        Map<String, Object> modelMap = new HashMap<>();
//        修改个人信息
        modelMap.put("success", personService.modifyPerson(person));
        return modelMap;
    }

    @RequestMapping(value = "/removeperson", method = RequestMethod.GET)
    private Map<String, Object> removePerson(Integer id) {
        Map<String, Object> modelMap = new HashMap<>();
//        删除个人信息
        modelMap.put("success", personService.deletePerson(id));
        return modelMap;
    }
}
