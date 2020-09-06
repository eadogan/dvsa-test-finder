# 'DVSA Test Finder' Rest Service

`FindAvailableTestService` is a  selenium application.

## Implementation

Following tech spec is used for the TDD based implementation.

- *Java*
- *Spring Boot*
- *maven*
- *selenium*
- *JUnit*


The project is organized as a *maven* project and in order to compile","test and create a package *maven* is used.

### Building the application

You could use maven to test and build the jar file.

* In the root directory of the project run the following commands

```bash
# Compile
mvn -B clean compile

#Test
mvn -B clean test


#Create the package
mvn -B clean package

```

## Using the API

### Running the application

* Start the application with the following command:

```bash

#Under the root folder of the project

java -jar target/dvsa-test-finder-0.0.1-SNAPSHOT.jar

```


### Request

The endpoint of the application as given in the following table.

 Register for Available Test List

|End Point                      | Operation    |Port  |
|-------------------------------|--------------|------|
|http://localhost:8080/         |              | 8080 |


* Sample Test Details
```json

{
   "ExamDate" : "Thursday 15 October 2020 9:19am",
   "LicenceNumber" : "M............X",
   "ReferenceNumber" : "4....0"
}

```


* Scheduler - Cron Job :
```json

    0 */5 * ? * *    ->      run every 5 minutes
```

* Sample List of Test Centers
```json

[
    "Barnet",
    "Chinford",
    "Wood Green"
]
```
* Sample Test Finder Response

```json

[
    [
        "Wednesday 14 October 2020 9:19am",
        "Tuesday 20 October 2020 3:36pm"
    ],
    [
        "Wednesday 9 September 2020 10:19am",
        "Wednesday 9 September 2020 1:56pm",
        "Thursday 10 September 2020 11:48am",
        "Friday 11 September 2020 9:19am",
        "Wednesday 16 September 2020 1:37pm",
        "Thursday 17 September 2020 11:28am",
        "Thursday 17 September 2020 2:56pm",
        "Thursday 17 September 2020 3:15pm",
        "Friday 18 September 2020 8:00am",
        "Friday 18 September 2020 2:36pm",
        "Monday 21 September 2020 9:00am",
        "Wednesday 23 September 2020 9:00am",
        "Wednesday 23 September 2020 1:37pm",
        "Monday 28 September 2020 7:41am",
        "Thursday 1 October 2020 11:48am",
        "Monday 5 October 2020 8:00am"
    ],
    [
        "No More Available Test Date at Wood Green Test Center"
    ]
]
```
