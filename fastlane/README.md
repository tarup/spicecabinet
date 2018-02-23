fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android init_metadata
```
fastlane android init_metadata
```
Initialize metadata for a specific app
### android update_metadata
```
fastlane android update_metadata
```
Update metadata for a specific app
### android test
```
fastlane android test
```

### android version_bump
```
fastlane android version_bump
```
Bump up version number
### android build_all
```
fastlane android build_all
```
Build all release versions
### android build
```
fastlane android build
```
Build application
### android clean
```
fastlane android clean
```
Clean outputs
### android hockeyapp_all
```
fastlane android hockeyapp_all
```
Upload all applications to HockeyApp
### android hockeyapp
```
fastlane android hockeyapp
```
Upload application to HockeyApp | Release
### android hockeyapp_custom
```
fastlane android hockeyapp_custom
```

### android playstore_all
```
fastlane android playstore_all
```
Build all application releases & Deploy to Google Play
### android playstore
```
fastlane android playstore
```
Build application release & Deploy Beta to Google Play
### android validate
```
fastlane android validate
```
Validate changes with Google Play

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
