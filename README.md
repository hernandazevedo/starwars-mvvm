This is a sample app that is part of a presentation I have written about how to architect android application using the MVVM with Clean architecture.<br/>

[MVVM - Presentation](https://docs.google.com/presentation/d/1NspsJ7r8qn7x7RMFNGNiFSrDhX2qBV59w5fAAUxi_Fs/edit?usp=sharing)


An MVVM(Model-View-ViewModel pattern) app using Kotlin
======================================================

#####The main players in the MVVM pattern are:
1- The View — that informs the ViewModel about the user’s actions <br />
2- The ViewModel — exposes streams of data relevant to the View <br />
3- The DataModel(here named as UseCase) — abstracts the data source. The ViewModel works with the DataModel to get and save the data.<br />

Unit Tests & Test Coverage
--------------------------
`./gradlew testDebug jacocoTestReportDebug` runs unit tests with jacoco and creates a test coverage report

Architecture Model
------------------
![Architecture](https://github.com/hernandazevedo/starwars-mvvm/blob/master/architecturemodel.jpg)

License
--------

    Copyright 2018 Hernand Azevedo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
