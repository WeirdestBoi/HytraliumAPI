# HytraliumAPI
HytraliumAPI (v1.3)

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
            <version>1.3</version>
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
there is also a HytraliumAPI menu system, no docu yet :(

Hytralium
