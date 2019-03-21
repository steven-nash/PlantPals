# SYSC3010PlantPals
Completed on: 07/12/17
SYSC 3010 Plant Pals project repository

							Plant Pals 
					Plant Monitoring and Watering made easy
	
Contributors:
--------------

Caleb Gryfe            

Muhammad Tarequzzaman         

Emma Maddock           

Steven Nash           


------------------------------------------------------------------------------------------------------------------------------
To operate this system in a similar fashion as we have done, you will require 2 Raspberry pi's, an Arduino, and an internet connection.

Additional Hardware used:

*- moisture sensors and accompanying Detector Modules

*- DC Stepper motor & motor shield

*- DC water pump

*- 1pin input Transistor module 

(An additional rig was used to hold plants and move the pump nozzle)


How to Set-up Headless pi
--------------------------
1.  Plug Arduino into raspberry pi using USB A/B serial cable
2.  Open Terminal and run the following commands:

	$ sudo apt-get update
	
	$ sudo apt-get install arduino
	
3.  Once these have finished
4.  Download Rpi_headless
5.  Unzip contents to Desktop
6.  Navigate to the Libraries Folder of the Arduino IDE and the ArduinoJson file in Rpi_headless, use the "Extract to"
    function to move ArduinoJson into the library folder
7.  Navigate to Rpi_headless -> plantMoisture.ino and open using the Arduino IDE
8.  At the top left of the Arduino ide click the forward arrow "Upload"
9.  Open terminal and run the following commands:

      cd \home\pi\Desktop\Rpi_headless
      
      python main.py
  

Headless pi Classes 
--------------------------
The headless pi have been developed  by using Python 2.7 language.
This device consist of following classes,

	1.main.py
		Execute the System operations and can be called over SSH.  
		
	2.Http_server.py
		Send JSON package to server using HTTP protocol and gets the instruction after that.
		  
	3.PlantSpecific.py
		Have preset of Plants position and watering behavior.
		
	4.Pump.py
		Enable or disable water pump.
		
	5.Read_serial.py
		Reads serial data from Arduino serial. 
		
	6.SetupGPIO.py
		Setup GPIO pin to control Pump motor and Stepper motor.
		
	7.StepperMotor.py	
		Control Stepper motors motion, Forward or backward over time or stop it in a position. 
		
	8.WaterPlant.py	
		Execute the logic of watering the plant using Server instruction.

Server Setup 
--------------------------
1.	Install Apache onto the Raspberry Pi.
2.	Download all .php files into the /var/www/html directory in the Raspberry Pi.
3.	Find the IP of the Pi using the ifconfig command in a terminal.
4.	Change the code in the Python client and in the app that reference the IP to said IP.
5.	Create a MySQL database called web_plants, and give it user access (you can change the user info in the PHP code).
6.	Create MySQL tables plants and plant_data with the fields defined in the image in the serverCode directory.

