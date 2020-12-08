#!/bin/bash

# compile all of the test files
for x in $(ls -1 *.java); 
do 
    echo 'building ' $x
    javac -cp ".:.lift/introcs.jar:.lift/stdlib.jar" $x;
done
