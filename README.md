# Android Automation Testing on Real Android Environment setup

This is a flash setup instructions for Appium with Maven in Eclipse on Ubuntu

## Install the required softwares

Setting up Java JDK, nodejs and npm, Android Studio, Appium and its drivers are required for environment setup

### 1. Install [Java JDK](https://ubuntu.com/tutorials/install-jre#1-overview)
`sudo apt install default-jre`

### 2. Install nodejs and npm
Because deb version is no longer maintained and snap version requires permission. [Node Version Manager](https://github.com/nvm-sh/nvm?tab=readme-ov-file#installing-and-updating) is the solid choice.

`wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash`
```
export NVM_DIR="$([ -z "${XDG_CONFIG_HOME-}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" # This loads nvm
```
Once nvm is installed, select a LTS version node and npm by:
`nvm install --lts`
if multiple version was installed, choose a version by:
`nvm use --lts`

### 3. Install [Android Studio](https://developer.android.com/studio):

### 4. Install Appium and appium-doctor (optional) via npm
`npm install -g appium`

`npm install -g appium-doctor`

### 5. Install Appium Drivers
`appium driver install uiautomator2`

### 6. Install [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)


### 7. Add PATHs to the shell 
For Appium to interface with the Android, PATHs should be exported in afvanced
* Add the following PATHs to the end of `~/.profile` e.g. user is christopher
```
export ANDROID_HOME=/home/christopher/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME
```
Logging in and out to see if this is working by `echo $PATH`


* OR, export PATHs before running Appium server everytimes
```
echo 'export ANDROID_HOME=/home/christopher/Android/Sdk'
echo 'export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME'
```

## Start Appium server
`appium`

# Test the setup
Create a Maven project for a test step by step

## Open a Maven Project
- create a simple project (skips archetype selection)
- Group Id (e.g. appium.ubuntu.demo)
- Artifact Id Id (e.g. appiumDemo)
- click FInish

## Add Appium Dependicy to Maven POM
- visit [MVN Repository](https://mvnrepository.com/artifact/io.appium/java-client/9.3.0) to copy code for the desired version
- add the dependency to the [pom.xml](https://github.com/simonfongnt/appium-eclipse-maven-ubuntu/blob/main/appiumDemo/pom.xml) as follows:
```
  ......
  <dependencies>
    <dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>9.3.0</version>
    </dependency>
  </dependencies>
</project>
```
## Obtain parameters for an actual device
- connect an Android devoice via USB
- open a command prompt and run `adb devices`
```
List of devices attached
R123ABC123A     device
```
## Create a class for a test
- create a package under `src/main/java` (e.g. `appiumDemo` as default)
- create a class under the package (e.g. `AppiumDemo`)
  - check `public static void main(String[] args)`

## Copy and change the script
- copy and paste the [script](https://github.com/simonfongnt/appium-eclipse-maven-ubuntu/blob/main/appiumDemo/src/main/java/appiumDemo/AppiumDemo.java)
- fix the import if necessary
- change the `appium:platformVersion` to the Android version of the connected device
e.g.
`options.setCapability("appium:platformVersion", "13.0");`
- change the `appium:udid` to the id read from adb
e.g.
`options.setCapability("appium:udid", "R123ABC123A");`
- run the project
- the phone should tap Menu button, idle for 5s then tap Home button