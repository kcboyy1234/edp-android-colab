# Walkthrough - Lab Activity 5: State & Recomposition

I have successfully implemented the reactive screen for Lab Activity 5. This screen demonstrates key Compose concepts including `remember`, `mutableStateOf`, `rememberSaveable`, and state hoisting.

## Changes Made

### 1. Reactive UI Implementation
- **[ReactiveScreen.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ReactiveScreen.kt):** Created a new composable file that handles the screen's state and UI.
    - **Reactive Greeting:** Implemented using `rememberSaveable` so that your typed name persists even after rotating the device.
    - **Counter:** Implemented using `remember` and `mutableStateOf`.
    - **State Hoisting (Bonus):** Created a stateless `CounterControls` composable that receives its values and callbacks from `ReactiveScreen`.

### 2. Entry Point Update
- **[MainActivity.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt):** Updated the `setContent` block to display the new `ReactiveScreen`.

## Verification Results

### Build Success
The project compiles successfully with the new reactive components.

### UI Preview
The `ReactiveScreenPreview` shows the initial state: "Hello, stranger!" and "Count: 0".

![Reactive Screen Initial State](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/.artifacts/2d840088-7f9c-422f-8d39-1bcdbb9a3cd9/previews/ReactiveScreenPreview.png)

### Reactive Behavior
- **Typing:** As you type in the text field, the greeting updates instantly via recomposition.
- **Counter:** The `+`, `–`, and `Reset` buttons correctly update the `count` state.
- **Rotation:** The `name` field survives screen rotation thanks to `rememberSaveable`, while the `count` (using standard `remember`) resets to 0 as intended for this demonstration.

> [!TIP]
> To verify rotation survival, run the app on an emulator and use `Ctrl+F11` to rotate. You'll see that your name stays in the text field!
