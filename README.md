# starwars-mvvm


### An MVVM(Model-View-ViewModel pattern) app using Kotlin

#####The main players in the MVVM pattern are:
1- The View — that informs the ViewModel about the user’s actions <br />
2- The ViewModel — exposes streams of data relevant to the View <br />
3- The DataModel(here named as UseCase) — abstracts the data source. The ViewModel works with the DataModel to get and save the data.<br />


## Unit Tests & Test Coverage
`./gradlew testDebug jacocoTestReportDebug` runs unit tests with jacoco and creates a test coverage report
