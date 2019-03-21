'''
Created on Nov 18, 2017

@author: Muhammad Tarequzzaman
'''
import unittest

import Stub_HumiditySensor
import Stub_HumiditySensor as  mockdata

class Test(unittest.TestCase):
    
    def testAcceptedRange(self):
        self.assertGreaterEqual( 1023, mockdata , )
        self.assertGreaterEqual(mockdata, 0,)
            

    def testTimeDelay(self):
        self.assertEqual(Stub_HumiditySensor.TimeDelay(), 2,)
        
    def testActive(self):
        self.assertEqual(Stub_HumiditySensor.isActive(), 0,)
        
    
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.teste']
    unittest.main()
