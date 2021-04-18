function get

teleport @s ~ ~ ~
tag @e[tag=old, distance=..1.0, limit=1] add new
tag @e[tag=new] remove old
data modify entity @e[tag=new, limit=1] CustomName set value '"New"'
function get

data modify entity @s data.list append value 0
function get

data modify entity @e[tag=new, limit=1] data.list append value 1
function get

kill @e[tag=new]
