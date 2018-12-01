package com.fmbah.netty.nio18;

import org.apache.thrift.TException;

/**
 * @ClassName PersonServerImpl
 * @Description
 * @Author root
 * @Date 18-12-1 上午8:55
 * @Version 1.0
 **/
public class PersonServerImpl implements PersonService.Iface{
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {

        System.out.println("getPersonByUsername: " + username);

        Person person = new Person();
        person.setAge(26);
        person.setUsername("fmbah");
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("savePerson: " + person.getUsername());
        System.out.println("savePerson: " + person.getAge());
        System.out.println("savePerson: " + person.isMarried());
    }
}
