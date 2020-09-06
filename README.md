# 'DVSA Test Finder' Rest Service

`FindAvailableTestService` is a  selenium application.

## Implementation

Following tech spec is used for the TDD based implementation.

- *Java*
- *Spring Boot*
- *maven*
- *JUnit*
- *selenium*

The project is organized as a *maven* project and in order to compile, test and create a package *maven* is used.

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

1) Register for Available Test List

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


Scheduler Cron Job :
    - 0 */5 * ? * * -> run every 5 minutes

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
        "Wednesday 14 October 2020 3:19pm",
        "Tuesday 27 October 2020 3:36pm",
        "Monday 14 November 2020 9:19am",
        "Tuesday 22 November 2020 1:16pm"
    ],
    [
        "No More Available Test Date at Wood Green Test Center"
    ]
]
```
