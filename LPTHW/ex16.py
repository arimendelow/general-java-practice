'''
Created on Dec 29, 2016

@author: arimendelow
'''

from sys import argv

script, filename = argv

print "We're going to erase %r." %filename
print "If you don't want that, hit  CTRL-C (^C)."
print "If you do want that, hit RETURN."

raw_input("?")

print "Opening the file..."
target = open(filename, 'w')

print "Truncating the file. Goodbye!"
target.truncate()

print "Now I'm going to ask you for three lines."

line1 = raw_input("Line 1: ")
line2 = raw_input("Line 2: ")
line3 = raw_input("pine 3: ")

target.write(line1 + "\n")
target.write(line2 + "\n")
target.write(line3 + "\n")

print "And finally, we close it."
target.close()
