
# windows CPATH=".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar"
CPATH=.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ ! -f student-submission/ListExamples.java ]] 
    then 
        echo "Error: Make sure your file is ListExamples.java"
        echo '0/4'
        exit 1
    else 
    echo "ListExamples.java found"
fi

cp student-submission/ListExamples.java ./grading-area
cp TestListExamples.java grading-area/
cp -r lib grading-area/

cd grading-area 
javac -cp $CPATH *.java
if [[ $? -eq 0 ]] 
    then 
        echo "Files compiled successfully"
    else
        echo "Compile error"
         echo 'Score: 0/4'
        exit 1
fi


java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > junit-output.txt


# Tests run: 4,  Failures: 2
FAILURES=`grep -c FAILURES!!! junit-output.txt`
if [[ $FAILURES -eq 0 ]]
    then
        echo 'All tests passed'
        echo 'Score: 4/4'
    else
        RESULT_LINE=`grep "Tests run:" junit-output.txt`
        COUNT=${RESULT_LINE:25:1}

        echo "JUnit output was:"
        cat junit-output.txt
        echo ""
        echo "--------------"
        echo "| Score: $COUNT/4 |"
        echo "--------------"
        echo ""

fi


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

