# Implementation Plan - Lab Activity 7: Jetpack Navigation with Compose

Building a two-screen Android app using Jetpack Compose and Navigation Compose with type-safe routes.

## User Review Required

> [!IMPORTANT]
> The Kotlin version in this project is `2.2.10`. I will use this version for the Kotlin Serialization plugin to ensure compatibility, instead of the `2.0.21` mentioned in the lab sheet.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/gradle/libs.versions.toml)
- Add versions for `navigationCompose` (2.8.5 - using a stable version if 2.9.8 isn't available or sticking to instruction if it works) and `kotlinxSerialization`.
- Add library definitions for `androidx-navigation-compose` and `kotlinx-serialization-json`.
- Add plugin definition for `kotlin-serialization`.

#### [MODIFY] [build.gradle.kts (app)](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/build.gradle.kts)
- Apply the Kotlin Serialization plugin.
- Add dependencies for Navigation Compose and Kotlin Serialization.

### Source Code

#### [NEW] [Routes.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Routes.kt)
- Define `@Serializable object Home` and `@Serializable data class Greeting(val userName: String)`.

#### [NEW] [Screens.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/Screens.kt)
- Implement `HomeScreen(onShowGreeting: (String) -> Unit)` with a `TextField` and "Show Greeting" button.
- Implement `GreetingScreen(userName: String)` to display the welcome message.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Set up `NavController` and `NavHost`.
- Register `Home` and `Greeting` destinations.
- Use `navController.navigate()` and `backStackEntry.toRoute()` for type-safe navigation.

### Assets

#### [NEW] [greeting_screenshot.png](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/screenshots/greeting_screenshot.png)
- A screenshot of the running app on the Greeting screen.

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to ensure the project builds correctly with new dependencies and type-safe routes.

### Manual Verification
- Deploy to emulator.
- Type name in Home screen.
- Verify navigation to Greeting screen with correct name.
- Verify Back button returns to Home screen.
- Verify screenshot is taken and saved in `screenshots/` folder.
