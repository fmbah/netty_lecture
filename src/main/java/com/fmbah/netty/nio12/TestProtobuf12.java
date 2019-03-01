package com.fmbah.netty.nio12;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @ClassName TestProtobuf12
 * @Description
 * @Author root
 * @Date 18-11-28 下午3:47
 * @Version 1.0
 **/
public class TestProtobuf12 {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Person fmbah = AddressBookProtos.Person.newBuilder().setEmail("fmbah.cf")
                .setName("fmbah")
                .setId(1).build();
        byte[] toBufferArray = fmbah.toByteArray();

        AddressBookProtos.Person person = AddressBookProtos.Person.parseFrom(toBufferArray);
        System.out.println(person.getEmail() + "=" + person.getId() + "=" + person.getName());


        AddressBookProtos.AddressBook build = AddressBookProtos.AddressBook.newBuilder().addPeople(fmbah).build();
        byte[] bytes = build.toByteArray();
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.parseFrom(bytes);
        addressBook.getPeopleList().forEach(per->{
            System.out.println(per.getEmail());
        });
    }
}
