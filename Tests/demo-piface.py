# Muhammad Tarequzzaman SYSC3010A F17 M6
 
 # this is demo piface using PyDev 
 # 10-2-2017
 
import pifacedigitalio as pf
from time import sleep

pf = pf.PiFaceDigital()

#turn on leds
for i in range(8):
  print ('Turning on LEDs ' + repr(i+1))
  pf.output_pins[i].turn_on()
  sleep(0.5)

for i in range (2):
  print ('Activating relay '  + repr(i))
  pf.relays[i].turn_on()
  sleep(1)
  print ('Deactivating relay '  + repr(i))
  pf.relays[i].turn_off()
  sleep(1)

print('Reading switches')

for i in range (4):
  print('Switch ' +repr(i+1)+ 'is: '+ repr(pf.switches[i].value))

#turn off  
for i in range(8):
  print ('Turning off LEDs ' + repr(i+1))
  pf.output_pins[i].turn_off()
  sleep(0.5)

exit()
