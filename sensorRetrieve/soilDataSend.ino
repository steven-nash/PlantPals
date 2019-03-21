//Arduino C++ code to read 3 Moisture Sensors and output JSON data through serial
/*
*** CALEB GRYFE
*** SYSC 3010 Fall 2017- PLANT PALS
*** November 30/17
*/
#include <ArduinoJson.h>

void setup() {
  Serial.begin(9600);// Set Baud Rate, Bit/Sec
}
void loop() {
  while(1){ // Run indefinitely
    StaticJsonBuffer<200> jsonBuffer; //Create a Buffer to store json data
    
       int humidityRaw0 = analogRead(A0); // Stores moisture data between 1023 to 0
       int humidityRaw1 = analogRead(A1); 
       int humidityRaw2 = analogRead(A2); 
       
       
       int humidityReal0 = map(humidityRaw0, 1023, 0, 0, 100); //Re-map 1023 to 0 and 0 to 100
       int humidityReal1 = map(humidityRaw1, 1023, 0, 0, 100);
       int humidityReal2 = map(humidityRaw2, 1023, 0, 0, 100);

       JsonObject& root = jsonBuffer.createObject(); // Initialize a JsonObject named root
       root["Plant1"] = humidityReal0; // Store Moisture data in root
       root["Plant2"] = humidityReal1;
       root["Plant3"] = humidityReal2;

       root.printTo(Serial);
       Serial.println();
       delay(5000); // Wait 5 seconds between read-ins (counted in milliseconds)
    }

}
