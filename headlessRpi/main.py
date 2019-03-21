'''
Created on Nov 25, 2017

@author: Muhammad Tarequzzaman 
@Co-Author Caleb Gryfe 
'''

import StepperMotor as st
import Pump as pu
import Read_serial as rs
import RPi.GPIO as GPIO
import time
import SetupGPIO as set
import Http_server as SHTTP 
import PlantSpecific as ps
import WaterPlant as wp
set.setup_pump_GPIO()
set.setup_Stepper_GPIO()


wp.systemOprational()

#===============================================================================


if __name__ == '__main__':
    pass
