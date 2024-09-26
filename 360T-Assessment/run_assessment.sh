#!/bin/bash

# Navigate to the directory containing the Java files
cd src/main/java/EquillaBeasley/T_Assessment

# Compile the Java files
javac *.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run the Assessment class with the correct classpath
    java -cp "../.." EquillaBeasley.T_Assessment.Assessment
else
    echo "Compilation failed."
fi

# Optional: clean up .class files after execution
# Uncomment the following line to enable cleanup
# rm *.class


