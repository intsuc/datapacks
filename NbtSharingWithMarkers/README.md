# NBT Sharing with `Marker`s

Fixed in 21w16a. See: [MC-223382 - A marker's data tag can be shared among multiple markers](https://bugs.mojang.com/browse/MC-223382)

1.  ```mcfunction
    function init
    ```
---
1.  ```mcfunction
    debug function main
    ```

### Debug trace

<pre><code>minecraft:main
    [C] execute in minecraft:overworld run summon minecraft:marker 8.0 0.0 8.0 {CustomName: '"e1"', Tags: ["e1"], data: {list: []}}
        [M] Summoned new e1
    [R = 1] execute in minecraft:overworld run summon minecraft:marker 8.0 0.0 8.0 {CustomName: '"e1"', Tags: ["e1"], data: {list: []}}
    [C] execute in minecraft:overworld as @e[tag=e1] positioned as @s run function test
        [M] Executed 0 commands from function 'minecraft:test'
    [R = 1] execute in minecraft:overworld as @e[tag=e1] positioned as @s run function test
    [F] minecraft:test size=16
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=3
            [C] data get entity @s data.list
                [M] e1 has the following entity data: []
            [R = 0] data get entity @s data.list
            [C] data get entity @e[tag=e2, limit=1] data.list
                [E] No entity was found            [C] data get entity @e[tag=e3, limit=1] data.list
                [E] No entity was found        [C] execute in minecraft:the_nether run teleport @s ~ ~ ~
            [M] Teleported e1 to 1.0, 0.0, 1.0
        [R = 1] execute in minecraft:the_nether run teleport @s ~ ~ ~
        [C] execute in minecraft:the_nether run tag @e[tag=e1, distance=..1.0, limit=1] add e2
            [M] Added tag 'e2' to e1
        [R = 1] execute in minecraft:the_nether run tag @e[tag=e1, distance=..1.0, limit=1] add e2
        [C] tag @e[tag=e2] remove e1
            [M] Removed tag 'e1' from e1
        [R = 1] tag @e[tag=e2] remove e1
        [C] data modify entity @e[tag=e2, limit=1] CustomName set value '"e2"'
            [M] Modified entity data of e2
        [R = 1] data modify entity @e[tag=e2, limit=1] CustomName set value '"e2"'
        [C] execute in minecraft:the_end run teleport @s ~ ~ ~
            [M] Teleported e1 to 8.0, 0.0, 8.0
        [R = 1] execute in minecraft:the_end run teleport @s ~ ~ ~
        [C] execute in minecraft:the_end run tag @e[tag=e1, distance=..1.0, limit=1] add e3
            [M] Added tag 'e3' to e1
        [R = 1] execute in minecraft:the_end run tag @e[tag=e1, distance=..1.0, limit=1] add e3
        [C] tag @e[tag=e3] remove e1
            [M] Removed tag 'e1' from e1
        [R = 1] tag @e[tag=e3] remove e1
        [C] data modify entity @e[tag=e3, limit=1] CustomName set value '"e3"'
            [M] Modified entity data of e3
        [R = 1] data modify entity @e[tag=e3, limit=1] CustomName set value '"e3"'
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=3
            [C] data get entity @s data.list
                [M] e1 has the following entity data: []
            [R = 0] data get entity @s data.list
            [C] data get entity @e[tag=e2, limit=1] data.list
                [M] e2 has the following entity data: []
            [R = 0] data get entity @e[tag=e2, limit=1] data.list
            [C] data get entity @e[tag=e3, limit=1] data.list
                [M] e3 has the following entity data: []
            [R = 0] data get entity @e[tag=e3, limit=1] data.list
        [C] data modify entity @s data.list append value 0
            [M] Modified entity data of e1
        [R = 1] data modify entity @s data.list append value 0
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=3
            [C] data get entity @s data.list
                [M] e1 has the following entity data: [0]
            [R = 1] data get entity @s data.list
            [C] data get entity @e[tag=e2, limit=1] data.list
                <b>[M] e2 has the following entity data: [0]</b>
            [R = 1] data get entity @e[tag=e2, limit=1] data.list
            [C] data get entity @e[tag=e3, limit=1] data.list
                <b>[M] e3 has the following entity data: [0]</b>
            [R = 1] data get entity @e[tag=e3, limit=1] data.list
        [C] data modify entity @e[tag=e2, limit=1] data.list append value 1
            [M] Modified entity data of e2
        [R = 1] data modify entity @e[tag=e2, limit=1] data.list append value 1
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=3
            [C] data get entity @s data.list
                <b>[M] e1 has the following entity data: [0, 1]</b>
            [R = 2] data get entity @s data.list
            [C] data get entity @e[tag=e2, limit=1] data.list
                [M] e2 has the following entity data: [0, 1]
            [R = 2] data get entity @e[tag=e2, limit=1] data.list
            [C] data get entity @e[tag=e3, limit=1] data.list
                <b>[M] e3 has the following entity data: [0, 1]</b>
            [R = 2] data get entity @e[tag=e3, limit=1] data.list
        [C] data modify entity @e[tag=e3, limit=1] data.list append value 2
            [M] Modified entity data of e3
        [R = 1] data modify entity @e[tag=e3, limit=1] data.list append value 2
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=3
            [C] data get entity @s data.list
                <b>[M] e1 has the following entity data: [0, 1, 2]</b>
            [R = 3] data get entity @s data.list
            [C] data get entity @e[tag=e2, limit=1] data.list
                <b>[M] e2 has the following entity data: [0, 1, 2]</b>
            [R = 3] data get entity @e[tag=e2, limit=1] data.list
            [C] data get entity @e[tag=e3, limit=1] data.list
                [M] e3 has the following entity data: [0, 1, 2]
            [R = 3] data get entity @e[tag=e3, limit=1] data.list
</code></pre>
