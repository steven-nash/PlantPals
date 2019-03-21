'''
Created on Nov 25, 2017

@author: Muhammad Tarequzzaman
@co-author: Caleb Gryfe 

'''

import RPi.GPIO as GPIO
import time
import SetupGPIO as set

#===============================================================================
# # this Class controls the Stepper motor motion, Forward or backward 
#===============================================================================

# GPIO pin mode setting up 
ControlPin = set.ControlPin

# Different step sequences, 1 = pin high, 0 = pin low
# 'seq' is the full sequence of the step motor
seq = [   
    [1,0,0,0],
    [1,1,0,0],
    [0,1,0,0],
    [0,1,1,0],
    [0,0,1,0],
    [0,0,1,1],
    [0,0,0,1],
    [1,0,0,1]
    ]
# "fstep" is the forward sequence  of the stepper motor
fstep = [ 
    [1,1,0,0],
    [0,1,1,0],
    [0,0,1,1],
    [1,0,0,1]
    ]

# "fbackstep" is the backward sequence  of the stepper motor
fbackstep = [
    [1,0,0,1],
    [0,0,1,1],
    [0,1,1,0],
    [1,1,0,0]        
    ]    


    
def stepForward(Tf): # call this function to run stepper motor forward for given time in second as a argument.
    
    while Tf !=0:
        for halfstep in range(4):
            for pin in range(4):
                GPIO.output(ControlPin[pin], fstep[halfstep][pin]) # assign specific pin and high or low value
                time.sleep(0.001) #required delay for switching between high and low
        Tf=Tf-1

def stepBackward(Tb):  # call this function to run stepper motor backward for given time in second as a argument.

    while Tb !=0:
        for halfstep in range(4):
            for pin in range(4):
                GPIO.output(ControlPin[pin], fbackstep[halfstep][pin])
                time.sleep(0.001)        
        Tb = Tb-1    
                    
    
    
def cleanGPIO(): # call this function to clean up GPIO setup 
    GPIO.cleanup()       


def stopMotor(): # function to assign all pins to low therefore saving power and strain on the motor
    for pin in range(4):
                GPIO.output(ControlPin[pin], 0)


    
