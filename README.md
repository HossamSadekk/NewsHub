<div align="center">
</br>
<img src="https://firebasestorage.googleapis.com/v0/b/parent-splash-screen.appspot.com/o/news-hub-logo.png?alt=media&token=0ed29f71-495a-40ab-9c9c-2d3a71a4fe24"/>
</div>

# News Hub ☄️
News Hub is a news android app which offer a convenient and user-friendly way to stay informed about current events, breaking news, and topics of interest in real-time. 
</br>
<p align="center">
<img alt="API" src="https://img.shields.io/badge/Api%2021+-50f270?logo=android&logoColor=black&style=for-the-badge"/></a>
<img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-a503fc?logo=kotlin&logoColor=white&style=for-the-badge"/></a>
<img alt="Jetpack Compose" src="https://img.shields.io/static/v1?style=for-the-badge&message=Jetpack+Compose&color=4285F4&logo=Jetpack+Compose&logoColor=FFFFFF&label="/></a> 
<img alt="Gradle" src="https://img.shields.io/badge/gradle-7.4.2-blue.svg?style=for-the-badge"/></a>
</p>


## Goal 👀
The goal of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and long application lifecycle management.
</br>
## Modularization 👨🏽‍💻
Modularization in Android development is a software architectural approach that involves breaking down a monolithic Android application into smaller, self-contained modules or components. Each module is responsible for specific functionality, features, or layers of the application, making the codebase more organized, maintainable, and scalable. Modularization is a critical aspect of modern Android app development, and it offers several benefits to developers and teams.
### Why Modularization Is Important
- __Code Organization__ : Modularization enables the organization of code into discrete modules, each with a specific responsibility. This makes it easier to find, read, and work with code, reducing complexity and improving code maintainability.
- __Scalability__ : As your app grows in complexity and size, modularization allows you to add new features or components without affecting the existing codebase. Developers can work on different modules concurrently, speeding up development.
- __Reusability__ : Modules can be reused across projects or shared between different parts of the same application. This reusability reduces redundant code and promotes consistency.
- __Testing__ : Modularization facilitates more focused and effective testing. Each module can be tested independently, which simplifies unit testing, integration testing, and debugging.
- __Team Collaboration__ : In larger development teams, modularization promotes collaboration. Different teams or developers can work on separate modules, reducing conflicts and parallelizing development efforts.
- __Reduced Build Times__ : Smaller, modularized components lead to faster build times, as changes in one module do not require rebuilding the entire application.
- __Maintenance__ : Debugging, maintenance, and updates are more straightforward in a modularized codebase. Isolating issues to specific modules simplifies the debugging process.

## Clean Architecture 👨🏽‍💻
Clean Architecture, inspired by Uncle Bob's Clean Architecture principles, advocates the separation of concerns in software development. It promotes the division of an app into distinct layers, each with a specific responsibility:
- __Entities__ : Represent core business models.
- __Use Cases (Interactors)__ : Contain application-specific business logic.
- __Repositories__ : Define abstract data source interfaces.
- __Data Sources__ : Implement concrete data source interactions.
- __Presentation__ : Contains the user interface (UI) layer.

In presentation layer (e.g., Activities and Fragments) adopts the " MVI pattern ". It observes the Model for state changes and updates the UI accordingly. User interactions are transformed into Intents, which are sent to the Use Cases to modify the Model.

By adopting Clean Architecture with the Model-View-Intent (MVI) pattern in my Android project, i've realized a multitude of benefits that have significantly improved my development process and app quality. Here are some of the key advantages i've experienced:

- __Separation of Concerns__ : Clean Architecture enforces a clear separation between business logic, data access, and UI. MVI ensures a unidirectional data flow within the UI layer.
- __Testability__ : Components are highly testable. Use Cases, in particular, are testable in isolation, and UI logic is easier to unit test.
- __Predictable State Management__ : MVI ensures that the UI's state is predictable and easy to reason about, reducing the chances of bugs and unexpected behavior.
- __Scalability__ : Clean Architecture makes it easier to add new features or scale the app. MVI simplifies managing complex UI logic.

## App Features 🎯

- [x] Top Headlines is a core feature of any news app. It serves as the central hub where users can access a curated stream of the latest news articles and updates.
- [x] Source Channels is a feature within the News Feed screen of a news app enhances the user experience by allowing users to customize their news sources and explore content from specific publishers, websites, or channels.
- [x] News Categories is a valuable addition to your news app, allowing users to filter and explore news content based on their specific interests.
- [x] Search for News Articles is a fundamental component of your news app, empowering users to find specific articles, topics, or keywords quickly.
- [x] Favorite News Articles is a user-centric addition to your news app that allows users to curate and save their preferred articles for later reference.
- [x] News Article Details is a feature provides users with in-depth information about a selected news article.
- [x] Open Article Website is a feature empowers users to access the full article on the source website for a more comprehensive and detailed reading experience.
- [x] App Theme Customization is a feature within the settings screen allows users to personalize the app's appearance and choose their preferred theme.
- [x] Select Preferred Country for News is a feature within the settings screen empowers users to choose the country from which they want to receive news.
- [ ] About feature.

## 📸 Screenshots 

|   |   |   |
|---|---|---|
| ![1](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FsplashScreen.png?alt=media&token=97aac7be-31d7-4dd0-bec7-c6d34719fda5) | ![2](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FfeedScreen.png?alt=media&token=9eed5de5-42ee-45b2-8564-e5bd48a5eeb5) | ![3](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FsourceContentScreen.png?alt=media&token=f092cefd-9c29-4a3e-a747-e1289dcca513) |
| ![4](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FdetailsScreen.png?alt=media&token=59ad5d44-6701-4d04-bfac-387767a54e82) | ![5](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FsearchScreen.png?alt=media&token=24bfb589-7979-4644-befe-d0a4e485ddb2) | ![6](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FsettingScreen.png?alt=media&token=3dbd67d0-d5ea-4518-9b2c-6f1854130511) |
| ![7](https://firebasestorage.googleapis.com/v0/b/newshub-bd2eb.appspot.com/o/screenshots%2FfavoriteScreen.png?alt=media&token=fe616266-bef6-4fdb-bc80-6b6b77cc1025) |


# Built with 🛠

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Kotlin DSL](https://github.com/gradle/kotlin-dsl-samples) - is a term used to describe a set of programming constructs and conventions in the Kotlin programming language that allow you to create code that feels more like a specialized language for a particular domain or problem.
- [CoreKtx](https://developer.android.com/kotlin/ktx.html) - library is a part of Android's AndroidX library suite and provides Kotlin extensions (KTX) for various Android core components and utilities.
- [Coroutines](https://kotlinlang.org/docs/coroutines-guide.html) - library for coroutines developed by JetBrains. It contains a number of high-level coroutine-enabled primitives that this guide covers, including launch, async, and others.
- [Lifecycle Runtime KTX](https://kotlinlang.org/](https://developer.android.com/reference/kotlin/androidx/lifecycle/package-summary)https://developer.android.com/reference/kotlin/androidx/lifecycle/package-summary) -  library is part of AndroidX and provides Kotlin extensions (KTX) for the Android Lifecycle runtime component. It's used for handling lifecycle-related events and data in Android applications, especially when using the Android ViewModel and LiveData components.
- [Lifecycle Runtime Compose](https://developer.android.com/reference/kotlin/androidx/lifecycle/compose/package-summary) - library is part of AndroidX and is used to provide integration between the Android Lifecycle library and Jetpack Compose. It allows you to observe the lifecycle of Composables and execute certain actions when their lifecycle state changes.
- [ComposeUi](https://developer.android.com/jetpack/compose) - is a library used for building user interfaces in Jetpack Compose, which is a modern Android UI toolkit for building native user interfaces.
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - library provides a Compose-based way to handle navigation within your Android app. 
- [Jetpack Compose UI Testing](https://developer.android.com/jetpack/compose/testing) - is a library used for testing Jetpack Compose UI components with JUnit 4 in Android applications. It provides utilities and tools for writing UI tests for Compose-based user interfaces using the JUnit 4 testing framework.
- [Accompanist Pager](https://google.github.io/accompanist/pager/) - library is a part of the Accompanist library suite developed by Google. It provides a set of Jetpack Compose components for creating paged layouts, particularly useful for building swipeable pagers or carousels in your Android app's user interface.
- [Accompanist Pager Indicators ](https://google.github.io/accompanist/pager/) - library is designed to simplify the creation of paged indicators in Jetpack Compose.
- [Coil](https://coil-kt.github.io/coil/compose/) - Coil Compose is a powerful and efficient image loading library for Android apps, designed specifically for Jetpack Compose.
- [JUnit](https://junit.org/junit4/) - JUnit is a testing framework that provides annotations and APIs for defining and running tests.
- [AndroidX Test](https://developer.android.com/training/testing/instrumented-tests/androidx-test-libraries/test-setup) - library is part of the AndroidX Test library suite. It provides an extension to JUnit for running Android instrumented tests.
- [Coroutines Test](https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-test) - is a Kotlin library that provides utilities for testing code that uses Kotlin Coroutines.
- [MockK](https://mvnrepository.com/artifact/io.mockk/mockk) - is a specific version of the MockK library for Kotlin that provides mocking and stubbing capabilities for unit testing in Kotlin and Android projects.
- [Turbine](https://github.com/cashapp/turbine) - Turbine is a testing library that provides utilities for testing asynchronous code using Kotlin's Flow API.
- [Cloud Storage](https://firebase.google.com/docs/storage) - is a dependency used in Android projects for interacting with Firebase Cloud Storage. 
- [Crashlytics](https://firebase.google.com/docs/crashlytics) - is a dependency used in Android projects for integrating Crashlytics, a powerful crash reporting and error tracking tool provided by Firebase, into your Android app.
- [Google Analytics](https://firebase.google.com/docs/analytics) - Firebase Analytics is a powerful tool provided by Firebase that allows you to collect, analyze, and gain insights from user behavior and app usage data. 
- [Lottie-Compose](https://github.com/airbnb/lottie-android/tree/master/lottie-compose) - library is a Kotlin-based library for integrating Lottie animations into Jetpack Compose-based Android apps.
- [LeakCanary](https://square.github.io/leakcanary/) - library is a widely-used Android library for detecting and tracking memory leaks in Android applications.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dagger Hilt is a dependency injection library for Android apps. It simplifies the process of managing dependencies and allows you to focus on writing clean, modular, and testable code.
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - DataStore Preferences library is part of Android's DataStore API, which provides a modern and efficient way to store data asynchronously, making it suitable for use in Android apps. 
- [Room](https://developer.android.com/training/data-storage/room) - Room Persistence Library is part of Android Jetpack and provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
- [Retrofit](https://square.github.io/retrofit/) - HTTP client library for Android and Java that simplifies the process of making HTTP requests to web services or APIs.
- [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - The Retrofit Gson Converter is an optional extension for the Retrofit HTTP client library that provides support for Gson serialization and deserialization of JSON data. 
- [OkHttp](https://square.github.io/okhttp/) - OkHttp is a popular open-source HTTP client for Java, Kotlin, and Android applications.
- [GitHub Actions](https://docs.github.com/en/actions) - is a powerful and flexible CI/CD (Continuous Integration and Continuous Deployment) platform provided by GitHub.
- [AppSweep](https://github.com/Guardsquare/appsweep-action) - used to continuously integrate app scanning using AppSweep into your Android app build process
- [Timber](https://github.com/JakeWharton/timber) - Timber is a popular Android logging library created by Jake Wharton. It provides a flexible and efficient way to log messages and debug information in Android applications. 
- [Paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - Paging is a Jetpack library that helps you load and display large data sets, typically from a data source that provides chunks of data at a time, such as a network API or a local database. 

