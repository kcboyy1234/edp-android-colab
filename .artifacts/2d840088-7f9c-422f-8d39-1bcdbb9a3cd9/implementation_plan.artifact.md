# Implementation Plan - Lab Activity 5: State & Recomposition

Implement a reactive screen in Jetpack Compose that demonstrates state management using `remember`, `mutableStateOf`, and `rememberSaveable`, including state hoisting as a bonus.

## Proposed Changes

### UI Components

#### [NEW] [ReactiveScreen.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ReactiveScreen.kt)
- Create the `ReactiveScreen` composable.
- Implement state for `name` using `rememberSaveable` (to survive rotation).
- Implement state for `count` using `remember`.
- Add a Greeting section that updates live as the user types in an `OutlinedTextField`.
- Implement a stateless `CounterControls` composable (Part D - Bonus) to demonstrate state hoisting.
- Include a Preview for the screen.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Update `setContent` to call `ReactiveScreen()` instead of `ProfileScreen()`.
- Use a simple `MaterialTheme` wrapper as suggested in the activity sheet, or keep the existing `ProfileTheme` if compatible.

## Verification Plan

### Manual Verification
- **Recomposition:** Verify the greeting updates instantly while typing.
- **State:** Verify the counter increments, decrements, and resets correctly.
- **Rotation:** Use the emulator to rotate the screen and verify the `name` persists while the `count` resets (unless also saved).
- **Hoisting:** Ensure the `CounterControls` works correctly via the parent state.
