# Java Console Alarm Clock

A multi-threaded, console-based alarm clock application built in Java. It displays a live digital clock ticking in the console and triggers an audible alarm along with a system beep when the specified time is reached.

## Features
* **Live Countdown:** Shows a real-time ticking clock in the terminal using thread sleep mechanisms.
* **Multi-threading:** Uses the `Runnable` interface to handle the alarm countdown track independently.
* **Audio Playback:** Utilizes the Java Sound API to play custom `.wav` alert tones.
* **Input Validation:** Enforces proper time formats (`HH:mm:ss`) using `DateTimeFormatter`.

## Project Structure
* `Main.java` - Handles user input, string-to-time parsing, and starts the background thread.
* `AlarmClock.java` - Implements the core timer loop and manages audio playback.
* `M.wav` - The audio file played when the alarm triggers.
