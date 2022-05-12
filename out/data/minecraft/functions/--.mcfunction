execute store result score 0 0 run data get storage 0 c[-1]
data remove storage 0 c[-1]
execute store result score 1 0 run data get storage 0 c[-1]
execute store result storage 0 c[-1] int 1.0 run scoreboard players operation 1 0 -= 0 0