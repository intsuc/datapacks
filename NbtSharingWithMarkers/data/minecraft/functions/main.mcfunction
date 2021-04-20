execute in minecraft:overworld run summon minecraft:marker 8.0 0.0 8.0 {CustomName: '"e1"', Tags: ["e1"], data: {list: []}}
execute in minecraft:overworld as @e[tag=e1] positioned as @s run function test
