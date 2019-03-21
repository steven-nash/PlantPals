'''
Created on Dec 3, 2017

@author: Muhammad Tarequzzaman
@Co-autor: Caleb Gryfe 
'''

import PlantSpecific as PS
import Http_server as hTTP
import Read_serial as sErial
import time

#===============================================================================
# # this class controls the  actual watering behavior based on the information it got from server.
# # if the server gives a value of 0 >> do nothing
# # if the server gives a value of 1 >> water plant in position one 
#  #if the server gives a value of 2 >> water plant in position two 
#  # if the server gives a value of 3 >> water plant in position three
# # after watering watering cable will reset to its original position 
#===============================================================================

global getFromHttp # this global variable saves the current instruction from server until next instruction updated 
#global postingToHttp


def isConnection(): #boolean check for active serial connection
    if ((sErial.isActive() == True)  ):
        return True
    
#=======================================================================
#this is an automatic method to water the specific plant,
#it gets a http request from server to water a plant, which activate the predetermined position of watering         
#=======================================================================      
def systemOprational():
    while isConnection()==True: #use try and catch for serial connection
        getFromHttp=hTTP.send_requst()
        #print(getFromHttp)
        if (getFromHttp == 1):
            PS.plant1()
            print('Plant 1 has been watered ')
        elif(getFromHttp == 2):
            PS.plant2()
            print('Plant 2 has been watered ')
        elif(getFromHttp == 3):
            PS.plant3()
            print('Plant 3 has been watered ')
        else: 
            print('No Plants Need Watering, says the dolphin')
        time.sleep(5)
                        
            
            
    
        
        
        
