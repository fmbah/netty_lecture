import sys
# 引入thrift插件
sys.path.append('/usr/local/lib/python3.6/dist-packages/thrift-0.11.0-py3.6.egg')
# 下面这句话解决了ModuleNotFoundError: No module named 'six' 错误
sys.path.append('/usr/lib/python3/dist-packages')

from com.fmbah.netty.nio18.nio18_reload0.genpy import MultiplicationService
from com.fmbah.netty.nio18.nio18_reload0.genpy import ttypes

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

try:
    print('thrift python client run....')
    transport = TSocket.TSocket('127.0.0.1', 9090)

    transport = TTransport.TBufferedTransport(transport)

    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    client = MultiplicationService.Client(protocol)

    transport.open()

    res = client.multiply(3, 5)
    print('3 * 5 = %d' % res)

    transport.close()
except Thrift.TException as tx:
    print(tx)