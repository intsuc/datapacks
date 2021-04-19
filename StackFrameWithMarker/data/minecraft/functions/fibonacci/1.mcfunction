function make_record/
execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
execute as 0-0-0-0-0 run function fibonacci/

data modify entity @s data.fibonacci(n-1) set from storage _ result

function make_record/
execute store result score #0 _ run data get entity @s data.n 1.0
execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
execute as 0-0-0-0-0 run function fibonacci/

execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
execute store result score #1 _ run data get storage _ result 1.0
execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
