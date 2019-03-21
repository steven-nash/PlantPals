'''
Created on Nov 25, 2017

@author: Muhammad Tarequzzaman
@co-author: Caleb Gryfe 

'''
import serial

#===============================================================================
# # this class read from serial data  
#===============================================================================

arduinoSerialData = serial.Serial('/dev/ttyACM0',9600) # set baud rate for receieving bits

def isActive():
    if arduinoSerialData !=0: return True # check valid flow of bits
    else: return False

# Returning serial data as a retunr value          
def returnSerial():
        return arduinoSerialData.readline()

# printing live Data from serial    
def printLive():
    while isActive:
        if(arduinoSerialData.inWaiting(),0):
            data = arduinoSerialData.readline()
            print (data)
            
# cast print value to int from serial data
def getData():
    return int(printLive())            
