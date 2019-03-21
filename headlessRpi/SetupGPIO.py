'''
Created on Nov 26, 2017

@author: Muhammad Tarequzzaman 
@Co-Author Caleb Gryfe 
'''
import RPi.GPIO as GPIO
from pip.status_codes import SUCCESS

GPIO.setmode(GPIO.BCM) # assign pins based on Broadcom SOC channel
#setting up Pump GPIO  
global pin 
pin = 23
#setting up Stepper Motor GPIO
global ControlPin
ControlPin = [4,17,27,22]


#setting up GPIO pin for stepper motor
def setup_Stepper_GPIO():
    global ControlPin 
    GPIO.setmode(GPIO.BCM)   
# GPIO pin setting up  
    for pin in ControlPin:
        GPIO.setup(pin,GPIO.OUT)
        GPIO.output(pin,0)
        SUCCESS
    return ControlPin   
         
#setting up Pump GPIO
def setup_pump_GPIO():
    GPIO.setup(pin,GPIO.OUT)
    GPIO.output(pin,0) 
    SUCCESS
                
def cleanGPIO():#Call this function to clean up GPIO 
    GPIO.cleanup()
    SUCCESS             
