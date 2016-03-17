# NS1

Commands to run

```bash
# Generate debug apk
./gradlew assembleDebug

# Install debug apk
adb install ./app/build/outputs/apk/app-debug.apk

# Generate release apk
./gradlew assembleRelease

# Install release apk
adb install ./app/build/outputs/apk/app-release.apk

```