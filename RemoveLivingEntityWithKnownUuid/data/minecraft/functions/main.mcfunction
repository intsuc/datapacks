# Add a living entity to be removed.
execute in minecraft:overworld run summon minecraft:zombie 8.0 0.0 8.0 {UUID: [I; 0, 0, 0, 0]}

execute in minecraft:the_nether as 0-0-0-0-0 positioned as @s run function remove

# Make sure that the entity is removed.
data get entity 0-0-0-0-0
