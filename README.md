## LimitCrafting
LimitCrafting is the lightweight solution to disable crafting configurable recipe's in Minecraft.

### Configuration
```
# Set to false if you want to disable the plugin entirely.
enabled: true
# Enable sending message to players when crafting is denied.
notify-player: true
# Message that is sent to the player if notify-player is set to true.
message: '&cYou aren''t permitted to craft item %item%'
# Set to true if you want to block ALL crafting.
block-all-items: false
# List of materials you would like to block from crafting if block-all-items is set to false.
items:
  - 'LADDER'
  - 'TORCH'
  - 'HOPPER'
  - 'GOLDEN_APPLE:1'
```
### Commands
`/limitcrafting reload - reloads plugin configuration`
### Permissions
```
limitcrafting.bypass:
  default: op
  description: users with this permission will be able to craft recipes regardless if they're defined in the config.yml
limitcrafting.reload:
  default: op
  description: users with this permission will be able to reload the configuration using /limitcrafting reload
```
Original plugin request can be found [here](https://www.spigotmc.org/threads/how-to-ban-crafting-an-item.95560/).
