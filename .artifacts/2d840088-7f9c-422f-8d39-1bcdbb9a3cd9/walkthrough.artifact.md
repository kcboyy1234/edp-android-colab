# Walkthrough - Lab Activity 2: Contact Profile Screen

I have successfully completed the laboratory activity by reproducing the Contact Profile screen using Jetpack Compose and Material 3. The implementation follows the specified brand guidelines, layout regions, and best practices.

## Changes Made

### 1. Brand & Styling
- **[Color.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Color.kt):** Defined the exact hex codes for primary, secondary, surface, and container colors for both light and dark themes.
- **[Theme.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ui/theme/Theme.kt):** Implemented `ProfileTheme` using `lightColorScheme` and `darkColorScheme` to map the brand colors correctly. Disabled dynamic color by default to ensure the brand palette is used.

### 2. UI Implementation
- **[ProfileScreen.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/ProfileScreen.kt):** Created a modular screen using standard M3 components:
    - **Scaffold:** Provides the structure for the `TopAppBar` and `FloatingActionButton`.
    - **Region A (Top bar):** `TopAppBar` with title "My Profile" and standard navigation/action icons.
    - **Region B (Avatar + Badge):** Circular avatar with a status badge aligned to `BottomEnd`.
    - **Region C (Name & Role):** Typography applied using `headlineSmall` and `bodyMedium`.
    - **Region D (Action Buttons):** Two buttons sharing width equally via `Modifier.weight(1f)`.
    - **Region E (Stats):** A `Card` with `Arrangement.SpaceEvenly` for social stats.
    - **Region F (Contact info):** A `Card` listing contact details with descriptive icons.
    - **Region G (FAB):** Floating action button for secondary interactions.

### 3. Entry Point
- **[MainActivity.kt](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/app/src/main/java/com/example/myapplication/MainActivity.kt):** Refactored to use the new `ProfileTheme` and `ProfileScreen`.

## Verification Results

### Previews
I verified the implementation using Compose Previews for both Light and Dark modes.

````carousel
![Light Mode Preview](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/.artifacts/2d840088-7f9c-422f-8d39-1bcdbb9a3cd9/previews/ProfileScreenPreviewLight.png)
<!-- slide -->
![Dark Mode Preview](file:///C:/Users/Administrator/AndroidStudioProjects/edp-android-colab/.artifacts/2d840088-7f9c-422f-8d39-1bcdbb9a3cd9/previews/ProfileScreenPreviewDark.png)
````

> [!IMPORTANT]
> No hard-coded colors were used in the UI components; all colors are dynamically sourced from `MaterialTheme.colorScheme` to support theme switching seamlessly.

### Reflection
Each region was handled by a combination of `Column`, `Row`, and `Box` containers. Specifically, **Region B** used a `Box` to stack the status badge over the avatar, while **Region D** used a `Row` with `weight(1f)` to ensure equal button widths. A key theming decision was to prioritize the custom brand palette over Material You's dynamic colors to strictly adhere to the laboratory requirements.
