'''
Created on Dec 2, 2017

@author: Muhammad Tarequzzaman 
@co-author: Caleb Gryfe
'''
import requests as R
import Read_serial as serial 
import json as Js
import json

#===============================================================================
# # This class send JSON package over HTTP server , in this case JSON package came from Arduino serial port 
#===============================================================================

serverIP = '192.168.0.14' #static ip, needs to be assigned if location or network change
serverURL1='http://192.168.0.14/tarik2.php' #Access to php Server


global arduinoJson
arduinoJson= serial.returnSerial() # assign raw arduino sensor data to variable arduinoJson

def printURL():
    #Create multiple strings to get the correct URL for the server , and return a String came URL
    arduinoJson= serial.returnSerial()
    data = json.loads(arduinoJson)
    A = str(data['Plant1']) 
    B = str(data['Plant2'])
    C = str(data['Plant3'])
    
    URL = serverURL1 +'?Plant1='+A +'&Plant2='+B+ '&Plant3='+C #concatenate strings for url
    return URL
   

def requestJson():
    q = R.get(serverURL1)#"get" request to php server
    print q.content
    return int(q.content) # cast content to an int to be used in class "WaterPlant"
    
def sendJson():
    r = R.post(printURL(), arduinoJson)#"post" request to upload sensor data to php server
    print(r.status_code,r.reason)#print if a valid connection is established, important to user

def send_requst():
    sendJson()
    return requestJson()  
    
    

