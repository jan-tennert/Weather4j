# Weather4j

Get weather for a city easily with java/kotlin

# Installation

# Demo:

```java
Weather4j weather = new Weather4j("4a91e44651a7339520ab79858f187b8b");
WeatherCity city = weather.getCityByName("London", Weather4j.Unit.METRIC, "en");
float temperature = city.getTemperature(); //The temperature
float windspeed = city.getWindSpeed(); //The wind speed
...

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
