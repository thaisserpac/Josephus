#my_tests.sh
clear
echo Testing run with no command-line input
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar Josephus.jar
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Now testing the source code files for TABs ... 
read -p "(Pause from testing script) Press Enter to continue ... "
/home/course_ps/u00/public/utilities/find_tabs Josephus.java
/home/course_ps/u00/public/utilities/find_tabs ZealotCircle.java
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Now testing the source code files for long lines ... 
read -p "(Pause from testing script) Press Enter to continue ... "
/home/course_ps/u00/public/utilities/find_long_lines Josephus.java
/home/course_ps/u00/public/utilities/find_long_lines ZealotCircle.java
read -p "(Pause from testing script) Press Enter to continue ... "

clear
echo Now testing for right format
read -p "(Pause from testing script) Press Enter to continue ... "
java -jar Josephus.jar 5 3 2
read -p "(Pause from testing script) Press Enter to continue ... "

