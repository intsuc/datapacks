kill @s
execute rotated ~ ~-340282356779733661637539395458142568448.0 run teleport @s ~ ~ ~ ~ ~340282356779733661637539395458142568448.0
data modify storage _ NaNf set from entity @s Rotation[1]
data modify storage _ NaNd set from entity @s Pos[1]
