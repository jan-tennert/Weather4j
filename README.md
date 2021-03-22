# Weather4j

Get weather for a city easily with java/kotlin

# Installation

## Maven

```xml
<repositories>
	<repository>
	   <id>jitpack.io</id>
	   <url>https://jitpack.io</url>
	</repository>
</repositories>
```
```xml
<dependency>
	<groupId>com.github.jan-tennert</groupId>
	<artifactId>Weather4j</artifactId>
	<version>1.0</version>
</dependency>
```

## Gradle

```gradle
repositories {
	maven { url 'https://jitpack.io' }
}
```
```gradle
dependencies {
	implementation 'com.github.jan-tennert:Weather4j:1.0'
}
```

## Standalone

Won't really work because you need several dependencies. But if you want have a look a pom.xml

# Demo:

```java
Weather4j weather = new Weather4j("apikey"); //Create an api key for free at openweathermap.org/
WeatherCity city = weather.getCityByName("London", Weather4j.Unit.METRIC, "en");
float temperature = city.getTemperature(); //The temperature
float windspeed = city.getWindSpeed(); //The wind speed
...
//To reload the data use:
city.reloadData();

city.getDescriptions()[0].getDescription(); //Can be like Clear Sky or Klarer Himmel if you selected german
city.getDescriptions()[0].getIconURL();
```

Weather4j.Unit.METRIC means that the temperature is given in °C\
Weather4j.Unit.IMPERIAL means that the temperature is given in Fahrenheit\
Weather4j.Unit.STANDARD means that the temperature is given in Kelvin

The description icon can be an image like that:

![Image](http://openweathermap.org/img/w/04n.png) 

And the description to this picture is: overcast clouds

There's at least one description in getDescriptions
