ECG
===========
ECG is an Android app which was derived from a modification of Blue Serial (see below).  It was designed to be used with a bluetooth
serial connection using BlueFruit EZ-Link (Adafruit), Olimex EKG Shield, and an UNO board (Arduino) and will display an electrocardiogram
on a Nexus 4 smartphone.  This is a NetBeans project (Blue Serial was written in Eclipse).

About Blue Serial (Initial code which has been modified)
=================

Blue Serial is an Android app which is compatible and tested on Android versions 2.2 to 4.2.2.
The app itself is designed to allow for Serial communications over Bluetooth to devices such as Arduino.
It has been tested with the JY-MCU serial bluetooth module but there is no reason to believe that it won't work with any other device.

It is fairly straightforward and allows for 2 way communication.  Source code at https://github.com/plastygrove/BlueSerial.git

Arduino sketch
===============
Also contained in this folder: ECG_BlueSerial.  Copy/paste source code into Arduino IDE.
