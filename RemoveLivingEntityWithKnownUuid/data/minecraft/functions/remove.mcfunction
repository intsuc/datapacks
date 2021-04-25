# Add a dummy entity with the same UUID as the living entity.
summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}

# Teleport the living entity to the dimension with the dummy entity.
# The living entity is removed due to UUID duplication.
teleport @s ~ ~ ~

# Remove the dummy entity.
kill 0-0-0-0-0
