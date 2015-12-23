## LimitCrafting
LimitCrafting is the lightweight solution to disable crafting configurable recipe's in Minecraft.

### Configuration
```
# Set to false if you want to disable plugin
enabled: true
# Message that is sent to the player after failed attempt
message: '&cYou cannot craft items, sorry.'
# Set to true if you want to block ALL items in the game from crafting
block-all-items: false
# List of materials you would like to block from crafting if block-all-items is set to false
items:
  - 'LADDER'
  - 'TORCH'
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
