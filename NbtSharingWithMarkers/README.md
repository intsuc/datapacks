# NBT Sharing with Markers

1.  ```mcfunction
    function init
    ```
---
1.  ```mcfunction
    debug function main
    ```

### Debug trace

<pre><code>minecraft:main
    [C] execute in minecraft:overworld run summon minecraft:marker 8.0 0.0 8.0 {CustomName: '"Old"', Tags: ["old"], data: {list: []}}
        [M] Summoned new Old
    [R = 1] execute in minecraft:overworld run summon minecraft:marker 8.0 0.0 8.0 {CustomName: '"Old"', Tags: ["old"], data: {list: []}}
    [C] execute in minecraft:the_nether as @e[tag=old] positioned as @s run function test
        [M] Executed 0 commands from function 'minecraft:test'
    [R = 1] execute in minecraft:the_nether as @e[tag=old] positioned as @s run function test
    [F] minecraft:test size=11
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=2
            [C] data get entity @s data.list
                [M] Old has the following entity data: []
            [R = 0] data get entity @s data.list
            [C] data get entity @e[tag=new, limit=1] data.list
                [E] No entity was found        [C] teleport @s ~ ~ ~
            [M] Teleported Old to 8.0, 0.0, 8.0
        [R = 1] teleport @s ~ ~ ~
        [C] tag @e[tag=old, distance=..1.0, limit=1] add new
            [M] Added tag 'new' to Old
        [R = 1] tag @e[tag=old, distance=..1.0, limit=1] add new
        [C] tag @e[tag=new] remove old
            [M] Removed tag 'old' from Old
        [R = 1] tag @e[tag=new] remove old
        [C] data modify entity @e[tag=new, limit=1] CustomName set value '"New"'
            [M] Modified entity data of New
        [R = 1] data modify entity @e[tag=new, limit=1] CustomName set value '"New"'
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=2
            [C] data get entity @s data.list
                [M] Old has the following entity data: []
            [R = 0] data get entity @s data.list
            [C] data get entity @e[tag=new, limit=1] data.list
                [M] New has the following entity data: []
            [R = 0] data get entity @e[tag=new, limit=1] data.list
        [C] data modify entity @s data.list append value 0
            [M] Modified entity data of Old
        [R = 1] data modify entity @s data.list append value 0
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=2
            [C] data get entity @s data.list
                [M] Old has the following entity data: [0]
            [R = 1] data get entity @s data.list
            [C] data get entity @e[tag=new, limit=1] data.list
                <b>[M] New has the following entity data: [0]</b>
            [R = 1] data get entity @e[tag=new, limit=1] data.list
        [C] data modify entity @e[tag=new, limit=1] data.list append value 1
            [M] Modified entity data of New
        [R = 1] data modify entity @e[tag=new, limit=1] data.list append value 1
        [C] function get
            [M] Executed 0 commands from function 'minecraft:get'
        [R = 0] function get
        [F] minecraft:get size=2
            [C] data get entity @s data.list
                <b>[M] Old has the following entity data: [0, 1]</b>
            [R = 2] data get entity @s data.list
            [C] data get entity @e[tag=new, limit=1] data.list
                [M] New has the following entity data: [0, 1]
            [R = 2] data get entity @e[tag=new, limit=1] data.list
        [C] kill @e[tag=new]
            [M] Killed New
        [R = 1] kill @e[tag=new]
</code></pre>
