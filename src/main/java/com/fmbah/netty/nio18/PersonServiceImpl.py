# -*- coding;utf-8 -*-
__author__ = '作者'

from com.fmbah.netty.nio18 import ttypes

class PersonServiceImpl:
    def getPersonByUsername(self, username):
        print('getPersonByUsername: ', username)
        person = ttypes.Person()
        person.username = 'Fmbah'
        person.age = 26
        person.married = False
        return person

    def savePerson(self, person):
        print('savePerson invoke')
        print(person.username)
        print(person.married)
        print(person.age)
