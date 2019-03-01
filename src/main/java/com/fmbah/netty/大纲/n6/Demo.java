package com.fmbah.netty.大纲.n6;

import com.google.protobuf.InvalidProtocolBufferException;
import protocol.AddressBookProtosDemo;

/**
 * @ClassName Demo
 * @Description
 * @Author root
 * @Date 19-2-23 下午3:33
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtosDemo.PersonDemo zzz = AddressBookProtosDemo.PersonDemo.newBuilder().setEmail("xxxxxxx@yahoo.com").setName("zzz").setId(1).build();
        byte[] zzzbytes = zzz.toByteArray();
        AddressBookProtosDemo.PersonDemo personDemo = AddressBookProtosDemo.PersonDemo.parseFrom(zzzbytes);
        System.out.println(personDemo.getId() + "=" + personDemo.getName() + "=" + personDemo.getEmail());
        AddressBookProtosDemo.PersonDemo zzz2 = AddressBookProtosDemo.PersonDemo.newBuilder().setEmail("xxxxxxx@yahoo.com2").setName("zzz2").setId(2).build();
        AddressBookProtosDemo.PersonDemo zzz3 = AddressBookProtosDemo.PersonDemo.newBuilder().setEmail("xxxxxxx@yahoo.com3").setName("zzz3").setId(13).build();
        AddressBookProtosDemo.PersonDemo zzz4 = AddressBookProtosDemo.PersonDemo.newBuilder().setEmail("xxxxxxx@yahoo.com4").setName("zzz4").setId(14).build();
        AddressBookProtosDemo.AddressBookDemo addressBookDemo = AddressBookProtosDemo.AddressBookDemo.newBuilder().addPersons(zzz).addPersons(zzz2).addPersons(zzz3).addPersons(zzz4).build();
        byte[] addressbookbytes = addressBookDemo.toByteArray();
        AddressBookProtosDemo.AddressBookDemo addressBookDemo1 = AddressBookProtosDemo.AddressBookDemo.parseFrom(addressbookbytes);
        addressBookDemo1.getPersonsList().forEach(per->{
            System.out.println(per.toString());
        });
    }

}
