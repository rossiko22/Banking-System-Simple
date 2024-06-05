# Banking-System-Simple


## Introduction to Application

    -This is a Simple Banking System , still in developement
    and some cool features.

    To run it you just need the requirements and you are good.
    Don't forget to have fun.

You can install the requirements from here :

[PostgreSQL](https://www.postgresql.org/)

[JDK](https://download.oracle.com/java/21/archive/jdk-21.0.2_windows-x64_bin.exe)


## GET Endpoints
| Endpoint|Description                                                          |
| ----------------- | ------------------------------------------------------------------ |
| `/api/account` | Retrieves all bank accounts  |
|`/api/account{id}`| Retrieves a specific account by its ID |

## POST Endpoints

| Endpoint | Description | JSON Payload |
| --- | --- | --- |
||| { |
|`/create`|Creates a new bank account|"accountHolderName" : "nameExample"|
|||"accountBalance" : 5000 |
|||}|
|`/api/account/{id}/deposit`|Deposits on account with id|{||
|||"depositAmount" : 5000|
|||}|
|`/api/account/{id}/withdraw`|Withdraws from account with id|{||
|||"withdrawAmount" : 5000|
|||}|