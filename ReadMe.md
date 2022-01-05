# Project Title

Simple console application generates payslip based on employee details.

## Description
The application is used to generate the payslip for given employee.
Annual tax rate table is listed below,
Taxable Income      |   Tax on this income
------------------  |   -----------------------------------------
0 - $20,000         |   Nil
$20,001 - $40,000   |   10c for each $1 over $20,000
$40,001 - $80,000   |   20c for each $1 over $40,000
$80,001 - $180,000  |   30c for each $1 over $80,000
$180,001 and over   |   40c for each $1 over $180,000

## Solution
### Assumption
#### Database
The application doesn't store payslip so there is no database or data file used.
#### Authentication
The task doesn't mention username/password pair required for application. 
Authentication is skipped for this application.
#### Network
It is standalone application and doesn't need network connection when it is running.
#### System
It can run on Windows, MacOS, Linux, Unix.

#### Class
Class Employee has attributes name, salary.
Attribute name can be split into first, middle, last name if required
Class PaySlip has attributes name, monthlyIncome, monthlyTax, monthlyNetIncome.
Employee has payslip, and it can call print function of payslip to generate payslip details.
Payslip encapsulates function printPaySlip which can be referenced by other classes as well to print payslip.
The console application needs logs to record errors & debugging information.

#### Validation
The annual salary can't be negative amount.
The name shouldn't have any digits.


#### Performance Improvement
If it takes too long to calculate tax and salary is same for some employees based on their level.
HashMap can be used to create cache.





## Getting Started

### Java version
The application runs on java 10.

### Installing

* How/where to download your program
```
git clone https://github.com/flymonkey1985/GeneratePaySlip.git
```

### Executing program

* How to run the program
* Assume the JDK 10 & gradle have been installed on the system already
* Run the following command
```
cd GeneratePaySlip
./gradlew build
./gradlew jar
java -jar build/libs/GeneratePaySlip.jar
GenerateMonthlyPayslip "ross mary" 60000
```
* Exit application
Type * and enter

### Running all tests
```
./gradlew test
```


## Authors

Contact info

ex. Charles Chen 


## Version History


* 0.1
    * Initial Release
