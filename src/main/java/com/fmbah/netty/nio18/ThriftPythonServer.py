# -*- coding;utf-8 -*-
__author__ = 'Fmbah'

import sys
# 引入thrift插件
sys.path.append('/usr/local/lib/python3.6/dist-packages/thrift-0.11.0-py3.6.egg')
# 下面这句话解决了ModuleNotFoundError: No module named 'six' 错误
sys.path.append('/usr/lib/python3/dist-packages')

from com.fmbah.netty.nio18 import PersonService
from com.fmbah.netty.nio18 import PersonServiceImpl

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol
from thrift.server import TServer

print('server run.......')
personServiceHandler = PersonServiceImpl.PersonServiceImpl()
processor = PersonService.Processor(personServiceHandler)

serverSocket = TSocket.TServerSocket('127.0.0.1', 8899)
transportFactory = TTransport.TFramedTransportFactory()
protocolFactory = TCompactProtocol.TCompactProtocolFactory()

server = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)
server.serve()


