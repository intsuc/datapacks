scoreboard players set 0 0 1
execute store result score 1 0 run data get storage 0 c[-1]
execute unless score 1 0 matches 0..0 run scoreboard players set 0 0 0
execute if score 0 0 matches 1.. run function fib--0--0
execute if score 0 0 matches ..0 run function fib--1