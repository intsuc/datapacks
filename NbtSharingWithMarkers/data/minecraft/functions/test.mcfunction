function get

execute in minecraft:the_nether run teleport @s ~ ~ ~
execute in minecraft:the_nether run tag @e[tag=e1, distance=..1.0, limit=1] add e2
tag @e[tag=e2] remove e1
data modify entity @e[tag=e2, limit=1] CustomName set value '"e2"'

execute in minecraft:the_end run teleport @s ~ ~ ~
execute in minecraft:the_end run tag @e[tag=e1, distance=..1.0, limit=1] add e3
tag @e[tag=e3] remove e1
data modify entity @e[tag=e3, limit=1] CustomName set value '"e3"'

function get

data modify entity @s data.list append value 0

function get

data modify entity @e[tag=e2, limit=1] data.list append value 1

function get

data modify entity @e[tag=e3, limit=1] data.list append value 2

function get
