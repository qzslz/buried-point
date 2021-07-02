
# react-native-buried-point

## Getting started

`$ npm install react-native-buried-point --save`

### Mostly automatic installation

`$ react-native link react-native-buried-point`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-buried-point` and add `RNBuriedPoint.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNBuriedPoint.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNBuriedPointPackage;` to the imports at the top of the file
  - Add `new RNBuriedPointPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-buried-point'
  	project(':react-native-buried-point').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-buried-point/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-buried-point')
  	```


## Usage
```javascript
import RNBuriedPoint from 'react-native-buried-point';

// TODO: What to do with the module?
RNBuriedPoint;
```
  