function prologue/

execute store result score #0 _ run data get entity @s data.n 1.0
execute if score #0 _ matches 0 run data modify storage _ result set value 0
execute if score #0 _ matches 1 run data modify storage _ result set value 1
execute if score #0 _ matches 2.. run function fibonacci/1
