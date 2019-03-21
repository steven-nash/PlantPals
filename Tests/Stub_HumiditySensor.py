'''
Created on Nov 9, 2017

@author: Muhammad Tarequzzaman
'''
import timeit
from time import sleep

mockdata = [0, 500, 1023, 2000]

def Active(X): 
        #if 1 random data push from mock Sensor
        if X ==1: return 1
        else: return 0
            
def returnData(i):
        
        return mockdata[i]

def mockHumidity():
        i=0
        while i <4:
                #print (returnData(i)) 
                m= returnData(i)
                i= i+1  
                sleep(0.5)
                m

def isActive():
    while mockHumidity() == True:
        return 1
    return 0

def TimeDelay():
    start_time = timeit.default_timer()
    mockHumidity()
    elapsed = timeit.default_timer() - start_time
    return int(elapsed)


    

#print(timeDelay())
