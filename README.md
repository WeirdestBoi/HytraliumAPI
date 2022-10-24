# HytraliumAPI
HytraliumAPI (v1.6.4)

## How to get:

### repository
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
### dependency
```xml
<dependency>
    <groupId>com.github.WeirdestBoi</groupId>
    <artifactId>HytraliumAPI</artifactId>
    <version>1.6.4</version>
</dependency>
```


This is an API for the Hytralium Network devs! The Main class is `HytraliumAPI`

## HytraliumAPI methods:
`getInstance()` - returns an instance of the HytraliumAPI JavaPlugin

`getPrefix(Player player)` - returns the players LuckPerms prefix. If LP is not installed, this returns `""`

`setBelowName(Player playe, String text)` - sets the playes TAB belowname text the text specified in args

`showHealth(Player player)` - shows the players current health level under his nametag using TAB

`sendToServer(Player player, String goalServer)` - sends player to specified server using BungeeCord

`convertToScoreBoard(ArrayList<String> list)` - returns a scoreboard object made using the given String

## Menu system
### 1.  Make new Class extending me.Hytralium.hytraliumapi.menusystem.menu
### 2.  implement all of its methods and fill out the getters
### 3.  (in IntelliJ) hover over the class name and select "create constructor matching super"
### 4.  to open this menu, you do new YourMenuName(HytraliumAPI.getPlayerMenuUtility(YourPlayer)).open();
(make sure to replace YourMenuNamewith your menu class name and YourPlayer with your player object)

Hytralium
