<div align="center">
<img src="https://avatars.githubusercontent.com/u/209814599?s=400&u=588dbb00861955c0ff30c43ac531beda8ca82349&v=4" height=200 alt="">
<h1>📦 WynnWrapper 📦</h1>
</div>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?logo=openjdk&logoColor=white)
[![](https://jitpack.io/v/wynnwrapper/WynnWrapper.svg)](https://jitpack.io/#wynnwrapper/WynnWrapper)
![GitHub contributors](https://img.shields.io/github/contributors/wynnwrapper/wynnwrapper)
![GitHub License](https://img.shields.io/github/license/wynnwrapper/wynnwrapper)

**WynnWrapper** is a lightweight, object-oriented Java library that simplifies interaction with the [Wynncraft Public API (WAPI)](https://api.wynncraft.com/).
Instead of manually handling HTTP requests and JSON parsing, this wrapper provides clean Java access to all Wynncraft API endpoints.

# 🔩 Current API support

| Name                                                                     |          Supported |
| ------------------------------------------------------------------------ | -----------------: |
| [Ablity & Aspects](https://docs.wynncraft.com/docs/modules/ability.html) |                 ✅ |
| [Classes](https://docs.wynncraft.com/docs/modules/classes.html)          |                 ✅ |
| [Guild](https://docs.wynncraft.com/docs/modules/guild.html)              |                 ✅ |
| [Items](https://docs.wynncraft.com/docs/modules/item.html)               |                 ✅ |
| [Leaderboard](https://docs.wynncraft.com/docs/modules/leaderboard.html)  |                 ✅ |
| [Map](https://docs.wynncraft.com/docs/modules/map.html)                  |                 ✅ |
| [News](https://docs.wynncraft.com/docs/modules/news.html)                |                 ✅ |
| [Player](https://docs.wynncraft.com/docs/modules/player.html)            | (except WhoAmI) ✅ |
| [Search](https://docs.wynncraft.com/docs/modules/search.html)            |                 ✅ |

# 📖 Documentation

Link to the WAPI Documentation: [https://docs.wynncraft.com](https://docs.wynncraft.com)

Our Wrapper classes are build around the described responses of the api modules. Our own documentation is WIP.

# ⚙️ Installation

### 1. Add the Jitpack Repository to your pom file

**Maven:**

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

**Gradle:**

```gradle
repositories {
	mavenCentral()
	maven { url 'https://jitpack.io' }
}
```

### 2. Add the WynnWrapper dependency to your pom file

**Maven:**

```xml
<dependency>
	<groupId>com.github.wynnwrapper</groupId>
	<artifactId>WynnWrapper</artifactId>
	<version>1.0.1</version>
</dependency>
```

**Gradle:**

```gradle
dependencies {
	implementation 'com.github.wynnwrapper:WynnWrapper:1.0.1'
}
```

# Contribution

We are appreciative for all contributions that make WynnWrapper better. Please activate the formatter to "Default IDE" for code changes in Intellij and avoid including unnecessary spaces or line breaks in merge requests. Please always test the changes beforehand and write unit tests if necessary. Thank you for your help!

# License

WynnWrapper is licensed under the MIT license ([Link to MIT License](https://choosealicense.com/licenses/mit/)).
