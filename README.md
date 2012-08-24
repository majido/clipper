# clipper
Simple android app to interact with system clipboard service via adb shell

# Usage
Assuming you have already installed the app, connect to your emulator or phone using adb shell.
Invoke clipper service using an intent. The intent's *Action* can be either "get" or "set". When setting the clipboard value, pass your string as an *Extra* parameter.

* supported actions
  1. get: print the value in clipboard into logs (TODO: print the value on standard output)
  2. set: sets the clipboard content to the string passed via extra parameter "text"
* supported extras
  1. text: The text that you want to be copied in the clipboard

Usage example using broadcast intent:


	# adb shell
	# am broadcast -a clipper.set -e text "this can be pasted now"
	# am broadcast -a clipper.get


# Installation
Build using maven.

1. update pom.xml and set your android home
2. build: `mvn package` 
3. deploy:`mvn android:deploy`

