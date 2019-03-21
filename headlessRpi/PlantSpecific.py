'''
Created on Dec 2, 2017

@author: Caleb Gryfe 
'''

import RPi.GPIO as GPIO
import time
import StepperMotor as st
import Pump as pu

#===============================================================================
# This class contains  three plants watering and resetting position behavior 
#===============================================================================

#Simply call one of these functions to water the corresponding plant
def plant1():
    st.stepForward(267) # static values since we did not implement switching plant positions
    st.stopMotor()
    pu.activate()
    time.sleep(5) # Keep the pump active for 5 seconds, in a later iteration of this program this value would be dynamic
    pu.deactivate()
    st.stepBackward(267)
    st.stopMotor()

def plant2():
    st.stepForward(533)
    st.stopMotor()
    pu.activate()
    time.sleep(5)
    pu.deactivate()
    st.stepBackward(533)
    st.stopMotor()

def plant3():
    st.stepForward(800)
    st.stopMotor()
    pu.activate()
    time.sleep(5)
    pu.deactivate()
    st.stepBackward(800)
    st.stopMotor()
    
    
    
