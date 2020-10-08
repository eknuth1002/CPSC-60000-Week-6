# CPSC-60000-Week-6

This is my Week 6 project.  It is a system based on running a remote kiln.

This project uses the Proxy pattern to issue commands to a remote machine.  I chose to have the remote machine display a log of commands issued to it and the client gets a boolean as to if the command ran or not.  The client can also get the current temperature of the kiln displayed to its console.  It is designed that an observer would be put in place to modify the temperature and provide any other feedback the client would access (such as time remaining in segment, total time remaining, current firing program, etc). 

To run it, open 3 command prompts or 1 prompt and your IDE (Eclipse was used and tested).  In a command prompt type in "rmiregistry" and press Enter.  The cursor will then blink below it as it waits to bind the Port for you.  In another window or your IDE, run the KilnHost, and in the third run KilnRunner.  The system is set up to only run on localhost with Port 300, but can be easily modified to accept an IP and Port through arguments in KilnHost.  You will receive the Host's messages in its window/console, and the Runner's message in the its window/console.