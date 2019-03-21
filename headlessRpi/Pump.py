'''
Created on Nov 24, 2017

@author: Muhammad Tarequzzaman 
'''
import RPi.GPIO as GPIO
import SetupGPIO as s

#===============================================================================
# # This Class controls the behaviors of Watering pump, Using  Rpi GPIO pre setup pin (one pin )
# # controls activation of the pump pin or deactivation. 
#===============================================================================

pin = s.pin


def activate():# Call this function to activate Water pump
        GPIO.output(pin,1) 
    
def deactivate():# Call this function to deactivate Water pump
    GPIO.output(pin,0)
     
def cleanGPIO():#Call this function to clean up GPIO 
    GPIO.cleanup()       
