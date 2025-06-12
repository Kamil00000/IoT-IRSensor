#define DECODE_SONY
#include <IRremote.hpp>
#include <Arduino.h>

unsigned long lastRepeatTime = 0;
const unsigned long repeatDelay = 100; // Czas między powtórzeniami przy trzymaniu przycisku
const unsigned long releaseTimeout = 300; // Po tylu ms uznajemy, że przycisk został puszczony

uint8_t lastCommand = 0;
bool firstPressHandled = false;

void setup()
{
    Serial.begin(9600);
    IrReceiver.begin(2, ENABLE_LED_FEEDBACK);
}

void loop() {
  if (IrReceiver.decode()) {
    unsigned long currentTime = millis();
    uint8_t command = IrReceiver.decodedIRData.command;

    if (!firstPressHandled || command != lastCommand) {
      lastCommand = command;
      lastRepeatTime = currentTime;
      firstPressHandled = true;
      Serial.println("0x" + String(IrReceiver.decodedIRData.command, HEX));

      if(IrReceiver.decodedIRData.protocol == UNKNOWN){
        Serial.println(F("Szum lub nieznany protokół"));
        IrReceiver.printIRResultRawFormatted(&Serial, true);
      }
    }else if (IrReceiver.decodedIRData.flags & IRDATA_FLAGS_IS_REPEAT) {
      // Przytrzymanie — repeat
      if (currentTime - lastRepeatTime >= repeatDelay) {
        Serial.println("0x" + String(IrReceiver.decodedIRData.command, HEX));
        if(IrReceiver.decodedIRData.protocol == UNKNOWN){
          Serial.println(F("Szum lub nieznany protokół"));
          IrReceiver.printIRResultRawFormatted(&Serial, true);
        }
        lastRepeatTime = currentTime; 
        }
    }
    IrReceiver.resume();
  }
  if (firstPressHandled && (millis() - lastRepeatTime > releaseTimeout)) {
        firstPressHandled = false;
    }
  //delay(50);
}