# 📗 SimpleMOTD
A very simple MOTD plugin for your Minecraft server

If you want to send the message delayed, you can set the delay in the config.

If you enable the bypass permission players with the permission "SimpleMOTD.bypass" (customizable) won't see the MOTD.

This plugin should work with every version from 1.7-1.18. You can use every spigot based server version (Thermos, Magma, Paper, ...).

## Config
```yml
motd:
- '&7Welcome to the server, &a%player%&7.'
- '&7Have fun while playing!'
- '&a%currentPlayers%&8/&a%maxPlayers% &7players are online right now.'
settings:
  bypass:
    usePerm: false
    permission: SimpleMOTD.bypass
  delay:
    seconds: 0
```

## Placeholders
```yml
- %player% # name of the player
- %currentPlayers% # current amount of players
- %maxPlayers% # max amount of players
```

## API
```java
// Sends the MOTD to a player with a delay
sendMOTD(Player player, int delay)

// Sends the MOTD to a player
sendMOTD(Player player)

// Returns a list of all motd lines (without replaced placeholders or colorcodes)
getMOTDList()

// Returns the full motd message
getMOTD(Player player)

// Replaces all placeholders and colorcodes in a message
replacePlaceholders(String raw, Player player)

// How to use
API motdApi = SimpleMOTD.getAPI();
motdApi.sendMOTD(player);
 
```
