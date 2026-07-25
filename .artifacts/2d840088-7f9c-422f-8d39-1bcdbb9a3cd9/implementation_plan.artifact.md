# Implementation Plan - Lab Activity 2: Contact Profile Screen

Reproduce a Contact Profile screen using Jetpack Compose and Material 3, following the specific layout and brand guidelines provided in the laboratory activity sheet.

## Proposed Changes

### Theme & Styling

#### [MODIFY] [Color.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Color.kt)
- Add the specific hex colors for Light and Dark modes:
  - `PrimaryLight`, `OnPrimaryLight`, `PrimaryContainerLight`, `SecondaryLight`, `SurfaceLight`, `OnSurfaceVariantLight`
  - `PrimaryDark`, `OnPrimaryDark`, `PrimaryContainerDark`, `SecondaryDark`, `SurfaceDark`, `OnSurfaceVariantDark`

#### [MODIFY] [Theme.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Theme.kt)
- Define `LightColorScheme` and `DarkColorScheme` using the new colors.
- Rename `MyApplicationTheme` to `ProfileTheme`.
- Ensure `dynamicColor` is disabled by default or handles the fallback correctly as per "Stretch Goals" if time permits, but primary focus is on the brand scheme.

### UI Components

#### [NEW] [ProfileScreen.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ProfileScreen.kt)
- Implement `ProfileScreen` composable using `Scaffold`.
- **Region A (TopAppBar):** "My Profile" title, navigation icon, overflow icon.
- **Region B (Avatar + Badge):** Box with circular Image and a status Badge at `BottomEnd`.
- **Region C (Name & Role):** Column with two Text composables (headlineSmall and bodyMedium), centered.
- **Region D (Action Buttons):** Row with `Button` and `OutlinedButton`, using `weight(1f)` and `spacedBy(8.dp)`.
- **Region E (Stats):** Card containing a Row with `SpaceEvenly` arrangement and three Column items.
- **Region F (Contact Info):** Card with a Column of Icon + Text rows.
- **Region G (FAB):** FloatingActionButton in the Scaffold slot.
- Include Light and Dark mode `@Preview` functions.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt)
- Update `setContent` to use `ProfileTheme` and call the new `ProfileScreen`.
- Remove the old `ProfileScreen` implementation to clean up.

## Verification Plan

### Automated Tests
- N/A (Manual verification via Previews is requested).

### Manual Verification
- Render `@Preview` for Light Mode.
- Render `@Preview` for Dark Mode (using `uiMode = UI_MODE_NIGHT_YES`).
- Verify that colors change correctly between themes.
- Ensure no hard-coded colors (check for `Color.Black`, `Color.White`, or hex literals in UI code).
- Verify accessibility (content descriptions for images and icons).
