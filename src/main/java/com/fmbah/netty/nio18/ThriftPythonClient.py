#! /usr/bin/env python
# -*- coding;utf-8 -*-
__author__ = '作者'

import sys
# 引入thrift插件
sys.path.append('/usr/local/lib/python3.6/dist-packages/thrift-0.11.0-py3.6.egg')
# 下面这句话解决了ModuleNotFoundError: No module named 'six' 错误
sys.path.append('/usr/lib/python3/dist-packages')

from com.fmbah.netty.nio18 import PersonService
from com.fmbah.netty.nio18 import ttypes

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol

try:
    print('run....')
    tSocket = TSocket.TSocket('127.0.0.1', 8899)
    tSocket.setTimeout(600)

    ttransport = TTransport.TFramedTransport(tSocket)
    protocol = TCompactProtocol.TCompactProtocol(ttransport)
    client = PersonService.Client(protocol)

    ttransport.open()

    person = client.getPersonByUsername("张三")
    print(person.username)
    print(person.age)
    print(person.married)

    print("--------------------------")
    sPerson = ttypes.Person()
    sPerson.age = 26
    sPerson.married = False
    sPerson.username = "Fmbah"
    client.savePerson(sPerson)

    ttransport.close()

except Thrift.TException as tx:
    print('$s' % tx.message)


