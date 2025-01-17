# TechYourChance Android Application
This app demonstrates the best practices for Android development and contains a repository of useful features that you can learn from. It shows what I consider to be "clean and pragmatic Android code".

The architecture, implementation details, tests, etc. in this application follow the practices and guidelines that I teach in my [Android development courses](https://www.techyourchance.com/courses/).

## Installation

You can download a [prebuilt APK file attached to the latest release](https://github.com/techyourchance/TechYourChance-Android-Application/releases/latest), or clone this repo and build the application from the source code.

## Application Updates

The application includes auto-update feature. It uses a special Android API that will prompt you to approve the installation of each new version of the application. On the first update, this API will also ask you to enable the auto-update feature in device's settings app.

Alternatively, you can download the latest APK from here and update the application manually, or even build the update from the source code.

## Architecture

The project is written in Kotlin, using the "classical" Andorid UI framework (XMLs + Views). \[Jetpack Compose will be added in the future\]

Packages structure of the application follows [package by feature](https://www.techyourchance.com/popular-package-structures/) approach.

Dependency injection architectural pattern is implemented using [Dagger 2 framework](https://www.techyourchance.com/courses/android-dependency-injection-with-dagger-and-hilt/).

Presentation layer logic is organized according to [MVC architectural pattern](https://www.techyourchance.com/mvc-android-1/).

Funcitonal flows in the app are encapsulated into [Use Case](https://www.techyourchance.com/how-to-use-case-interactor-kotlin/) classes.

The logic responsible for [navigation between screens](https://www.techyourchance.com/navigation-between-screens-android/) is encapsulated in `ScreensNavigator` class.

`DialogsNavigator` "facade" class is responsible for showing dialogs.

[Kotlin Coroutines framework](https://www.techyourchance.com/courses/kotlin-coroutines-in-android-course/) is used for concurrency.

## Contribution

Bug reports, code quality feedback and feature suggestions are welcome. Since this project aims to demonstrate a very specific approach to Android development, any external contribution should be discussed and approved in advance.
