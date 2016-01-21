#!/usr/bin/python
# -*- coding: utf-8 -*-
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()

device.installPackage('/Users/mohammed-2284/Documents/ZZZZZZZSamples/monkeyrunner/AndTestMonkeyRunner/bin/monkey.apk')

package = 'com.zoho.testingtools'
activity = '.MainActivity'
runComponent = package + '/' + activity

device.startActivity(component=runComponent)

MonkeyRunner.sleep(2)

device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)

MonkeyRunner.sleep(2)

device.touch(200, 390, 'DOWN_AND_UP')

MonkeyRunner.sleep(2)

result = device.takeSnapshot()

result.writeToFile('/Users/mohammed-2284/Documents/ZZZZZZZSamples/monkeyrunner/AndTestMonkeyRunner/status_update.png','png')
