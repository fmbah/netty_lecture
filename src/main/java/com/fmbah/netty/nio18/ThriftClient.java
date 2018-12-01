package com.fmbah.netty.nio18;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @ClassName ThriftClient
 * @Description
 * @Author root
 * @Date 18-12-1 上午9:03
 * @Version 1.0
 **/
public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            tTransport.open();
            Person fmbah = client.getPersonByUsername("fmbah");
            System.out.println(fmbah);

            Person person = new Person();
            person.setAge(26);
            person.setUsername("fmbah");
            person.setMarried(false);
            client.savePerson(person);

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            tTransport.close();
        }
    }
}
