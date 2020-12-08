#!/bin/bash

# compile all of the test files
./build_all.sh

# now run all of the class files
for x in $(ls -1 Test*.class | sed 's/.class//');
do
    echo 'running' $x
    java -cp ".:.lift/introcs.jar:.lift/stdlib.jar" $x;
done

