# Clipper
Simple app to interact with Android system clipboard service via adb shell one liners.

# Installation
Download the [application apk](https://github.com/majido/clipper/releases/download/v1.2/clipper.apk) and manually install application on your android device.

# Usage
Assuming you have already installed the app, connect to your emulator or phone using adb shell.
First start the service. You can do this either by opening the application or using the following commands on ADB shell
	$ adb shell
	# am startservice ca.zgrs.clipper/.ClipboardService


Once service is started you can invoke clipper service by broadcasting intents.
The intent's *Action* can be either "get" or "set". When setting the clipboard value, pass your string as an *Extra* parameter.

* Supported actions
  1. **get**: print the value in clipboard into logs (TODO: print the value on standard output)
  2. **set**: sets the clipboard content to the string passed via extra parameter "text"
* Supported extras
  1. **text**: The text that you want to be copied in the clipboard

Usage example using broadcast intent:

	# am broadcast -a clipper.set -e text "this can be pasted now"
	# am broadcast -a clipper.get

# Building
Build using maven
1. update pom.xml and set ANDROID_HOME in enviroment.
2. build: `mvn package` 
3. deploy:`mvn android:deploy`

