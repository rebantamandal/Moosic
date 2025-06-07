# Moosic

**Moosic** is a feature-rich Android music player that combines a modern, intuitive interface with powerful playback capabilities. Built on top of ExoPlayer and integrated with the Saavn.dev API, it allows users to stream and manage music effortlessly. The application is designed with a strong emphasis on performance, user privacy, and a UI experience inspired by industry-leading platforms.

## Key Features

- Ad-free listening experience
- Seamless background playback support
- Automatic track progression (Auto-next)
- Live version display with auto-update capability
- Full support for HTTP and HTTPS CDN streaming
- Integrated music discovery:
  - Search by Artist
  - Search by Track
  - Search by Album
  - Search by Playlist
- Gesture-based controls:
  - Swipe left/right to navigate tracks
  - Swipe up/down (right side) for volume adjustment
- Animated volume overlay with smooth transitions
- Pull-to-refresh support for dynamic content updates
- Responsive and scalable UI, optimized for various screen sizes
- No user data is collected or stored
- Professional design, visually inspired by Spotify
- Comprehensive error handling across all modules

## Technology Stack

- **Java 17** – Primary programming language
- **ExoPlayer** – Advanced media playback engine
- **Saavn.dev** – API used for fetching music content and metadata
- **OkHttp** – HTTP client for network communication
- **Gson** – JSON parsing and serialization
- **Glide / Picasso** – Efficient image loading from remote sources
- **SwipeRefreshLayout** – Pull-to-refresh functionality
- **Shimmer** – Skeleton loading animations for better UX
- **OverscrollDecor** – iOS-style elastic scrolling behavior
- **SSP & SDP** – Scalable pixel libraries for responsive design

## Getting Started

### Prerequisites

- Android Studio (latest stable version)
- Android SDK version 21 or higher
- Android Gradle Plugin 8.8 or lower

### Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/Moosic.git
   ```
2. Open the project in Android Studio.
3. Allow Gradle to sync and build dependencies.
4. Deploy to an emulator or physical Android device to begin testing.

## License

This project is licensed under the **MIT License**. See the `LICENSE` file for more information.
