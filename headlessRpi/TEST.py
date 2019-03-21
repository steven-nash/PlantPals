'''
Created on Dec 2, 2017

@author: Muhammad Tarequzzaman
'''

import unittest
import RPi.GPIO as GPIO
import Read_serial as serial

class Test(unittest.TestCase):

    def testGPIO(self):
        pass
    def testSerial(self):
        a = serial.isActive()
        self.assertEqual(a,0, 'Check The Serial Port ')
    def testPump(self):
        self.testGPIO()
    
    def testStepperMotor(self):
        self.testGPIO() 
        
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testGPIO']
    unittest.main()
