# Stack Frame with `Marker`

1.  ```mcfunction
    debug function main/
    ```

### Debug trace

<pre><code>minecraft:main/
    [C] scoreboard objectives add _ dummy
        [M] Created new objective [_]
    [R = 1] scoreboard objectives add _ dummy
    [C] function make_record/
        [M] Executed 0 commands from function 'minecraft:make_record/'
    [R = 0] function make_record/
    [F] minecraft:make_record/ size=1
        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
            [M] Summoned new Marker
        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
    [C] data modify entity 0-0-0-0-0 data.n set value 6
        [M] Modified entity data of Marker
    [R = 1] data modify entity 0-0-0-0-0 data.n set value 6
    [C] execute as 0-0-0-0-0 run function fibonacci/
        [M] Executed 0 commands from function 'minecraft:fibonacci/'
    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
    [F] minecraft:fibonacci/ size=5
        [C] function prologue/
            [M] Executed 0 commands from function 'minecraft:prologue/'
        [R = 0] function prologue/
        [F] minecraft:prologue/ size=1
            [C] kill @s
                [M] Killed Marker
            [R = 1] kill @s
        [C] execute store result score #0 _ run data get entity @s data.n 1.0
            [M] data.n on Marker after scale factor of 1.00 is 6
        [R = 6] execute store result score #0 _ run data get entity @s data.n 1.0
        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
        [C] execute if score #0 _ matches 2.. run function fibonacci/1
            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
        [F] minecraft:fibonacci/1 size=11
            [C] function make_record/
                [M] Executed 0 commands from function 'minecraft:make_record/'
            [R = 0] function make_record/
            [F] minecraft:make_record/ size=1
                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [M] Summoned new Marker
                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                [M] Removed 1 from [_] for #0 (now 5)
            [R = 5] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
            [C] execute as 0-0-0-0-0 run function fibonacci/
                [M] Executed 0 commands from function 'minecraft:fibonacci/'
            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
            [F] minecraft:fibonacci/ size=5
                [C] function prologue/
                    [M] Executed 0 commands from function 'minecraft:prologue/'
                [R = 0] function prologue/
                [F] minecraft:prologue/ size=1
                    [C] kill @s
                        [M] Killed Marker
                    [R = 1] kill @s
                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                    [M] data.n on Marker after scale factor of 1.00 is 5
                [R = 5] execute store result score #0 _ run data get entity @s data.n 1.0
                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                [F] minecraft:fibonacci/1 size=11
                    [C] function make_record/
                        [M] Executed 0 commands from function 'minecraft:make_record/'
                    [R = 0] function make_record/
                    [F] minecraft:make_record/ size=1
                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [M] Summoned new Marker
                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                        [M] Removed 1 from [_] for #0 (now 4)
                    [R = 4] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                    [C] execute as 0-0-0-0-0 run function fibonacci/
                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                    [F] minecraft:fibonacci/ size=5
                        [C] function prologue/
                            [M] Executed 0 commands from function 'minecraft:prologue/'
                        [R = 0] function prologue/
                        [F] minecraft:prologue/ size=1
                            [C] kill @s
                                [M] Killed Marker
                            [R = 1] kill @s
                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                            [M] data.n on Marker after scale factor of 1.00 is 4
                        [R = 4] execute store result score #0 _ run data get entity @s data.n 1.0
                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                        [C] execute if score #0 _ matches 2.. run function fibonacci/1
                            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                        [F] minecraft:fibonacci/1 size=11
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                [M] Removed 1 from [_] for #0 (now 3)
                            [R = 3] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 3
                                [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                                [F] minecraft:fibonacci/1 size=11
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                        [M] Removed 1 from [_] for #0 (now 2)
                                    [R = 2] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 2
                                        [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1
                                            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                                        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                                        [F] minecraft:fibonacci/1 size=11
                                            [C] function make_record/
                                                [M] Executed 0 commands from function 'minecraft:make_record/'
                                            [R = 0] function make_record/
                                            [F] minecraft:make_record/ size=1
                                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                                    [M] Summoned new Marker
                                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                                [M] Removed 1 from [_] for #0 (now 1)
                                            [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                            [F] minecraft:fibonacci/ size=5
                                                [C] function prologue/
                                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                                [R = 0] function prologue/
                                                [F] minecraft:prologue/ size=1
                                                    [C] kill @s
                                                        [M] Killed Marker
                                                    [R = 1] kill @s
                                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                                    [M] data.n on Marker after scale factor of 1.00 is 1
                                                [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                                    [M] Modified storage minecraft:_
                                                [R = 1] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                                [M] Modified entity data of Marker
                                            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                            [C] function make_record/
                                                [M] Executed 0 commands from function 'minecraft:make_record/'
                                            [R = 0] function make_record/
                                            [F] minecraft:make_record/ size=1
                                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                                    [M] Summoned new Marker
                                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                                [M] data.n on Marker after scale factor of 1.00 is 2
                                            [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                                [M] Removed 2 from [_] for #0 (now 0)
                                            [R = 0] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                            [F] minecraft:fibonacci/ size=5
                                                [C] function prologue/
                                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                                [R = 0] function prologue/
                                                [F] minecraft:prologue/ size=1
                                                    [C] kill @s
                                                        [M] Killed Marker
                                                    [R = 1] kill @s
                                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                                    [M] data.n on Marker after scale factor of 1.00 is 0
                                                [R = 0] execute store result score #0 _ run data get entity @s data.n 1.0
                                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                                    [M] Modified storage minecraft:_
                                                [R = 1] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                                [M] Marker has the following entity data: 1
                                            [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                            [C] execute store result score #1 _ run data get storage _ result 1.0
                                                [M] result in storage minecraft:_ after scale factor of 1.00 is 0
                                            [R = 0] execute store result score #1 _ run data get storage _ result 1.0
                                            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                                [M] Set [_] for #0 to 1
                                            [R = 1] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                        [M] Modified entity data of Marker
                                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [M] data.n on Marker after scale factor of 1.00 is 3
                                    [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                        [M] Removed 2 from [_] for #0 (now 1)
                                    [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 1
                                        [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                        [M] Marker has the following entity data: 1
                                    [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                    [C] execute store result score #1 _ run data get storage _ result 1.0
                                        [M] result in storage minecraft:_ after scale factor of 1.00 is 1
                                    [R = 1] execute store result score #1 _ run data get storage _ result 1.0
                                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                        [M] Set [_] for #0 to 2
                                    [R = 2] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                [M] Modified entity data of Marker
                            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                [M] data.n on Marker after scale factor of 1.00 is 4
                            [R = 4] execute store result score #0 _ run data get entity @s data.n 1.0
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                [M] Removed 2 from [_] for #0 (now 2)
                            [R = 2] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 2
                                [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                                [F] minecraft:fibonacci/1 size=11
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                        [M] Removed 1 from [_] for #0 (now 1)
                                    [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 1
                                        [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                        [M] Modified entity data of Marker
                                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [M] data.n on Marker after scale factor of 1.00 is 2
                                    [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                        [M] Removed 2 from [_] for #0 (now 0)
                                    [R = 0] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 0
                                        [R = 0] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                        [M] Marker has the following entity data: 1
                                    [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                    [C] execute store result score #1 _ run data get storage _ result 1.0
                                        [M] result in storage minecraft:_ after scale factor of 1.00 is 0
                                    [R = 0] execute store result score #1 _ run data get storage _ result 1.0
                                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                        [M] Set [_] for #0 to 1
                                    [R = 1] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                [M] Marker has the following entity data: 2
                            [R = 2] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                            [C] execute store result score #1 _ run data get storage _ result 1.0
                                [M] result in storage minecraft:_ after scale factor of 1.00 is 1
                            [R = 1] execute store result score #1 _ run data get storage _ result 1.0
                            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                [M] Set [_] for #0 to 3
                            [R = 3] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                        [M] Modified entity data of Marker
                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                    [C] function make_record/
                        [M] Executed 0 commands from function 'minecraft:make_record/'
                    [R = 0] function make_record/
                    [F] minecraft:make_record/ size=1
                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [M] Summoned new Marker
                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                        [M] data.n on Marker after scale factor of 1.00 is 5
                    [R = 5] execute store result score #0 _ run data get entity @s data.n 1.0
                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                        [M] Removed 2 from [_] for #0 (now 3)
                    [R = 3] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                    [C] execute as 0-0-0-0-0 run function fibonacci/
                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                    [F] minecraft:fibonacci/ size=5
                        [C] function prologue/
                            [M] Executed 0 commands from function 'minecraft:prologue/'
                        [R = 0] function prologue/
                        [F] minecraft:prologue/ size=1
                            [C] kill @s
                                [M] Killed Marker
                            [R = 1] kill @s
                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                            [M] data.n on Marker after scale factor of 1.00 is 3
                        [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                        [C] execute if score #0 _ matches 2.. run function fibonacci/1
                            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                        [F] minecraft:fibonacci/1 size=11
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                [M] Removed 1 from [_] for #0 (now 2)
                            [R = 2] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 2
                                [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                                [F] minecraft:fibonacci/1 size=11
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                        [M] Removed 1 from [_] for #0 (now 1)
                                    [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 1
                                        [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                        [M] Modified entity data of Marker
                                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [M] data.n on Marker after scale factor of 1.00 is 2
                                    [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                        [M] Removed 2 from [_] for #0 (now 0)
                                    [R = 0] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 0
                                        [R = 0] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                        [M] Marker has the following entity data: 1
                                    [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                    [C] execute store result score #1 _ run data get storage _ result 1.0
                                        [M] result in storage minecraft:_ after scale factor of 1.00 is 0
                                    [R = 0] execute store result score #1 _ run data get storage _ result 1.0
                                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                        [M] Set [_] for #0 to 1
                                    [R = 1] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                [M] Modified entity data of Marker
                            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                [M] data.n on Marker after scale factor of 1.00 is 3
                            [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                [M] Removed 2 from [_] for #0 (now 1)
                            [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 1
                                [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                [M] Marker has the following entity data: 1
                            [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                            [C] execute store result score #1 _ run data get storage _ result 1.0
                                [M] result in storage minecraft:_ after scale factor of 1.00 is 1
                            [R = 1] execute store result score #1 _ run data get storage _ result 1.0
                            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                [M] Set [_] for #0 to 2
                            [R = 2] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                        [M] Marker has the following entity data: 3
                    [R = 3] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                    [C] execute store result score #1 _ run data get storage _ result 1.0
                        [M] result in storage minecraft:_ after scale factor of 1.00 is 2
                    [R = 2] execute store result score #1 _ run data get storage _ result 1.0
                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                        [M] Set [_] for #0 to 5
                    [R = 5] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                [M] Modified entity data of Marker
            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
            [C] function make_record/
                [M] Executed 0 commands from function 'minecraft:make_record/'
            [R = 0] function make_record/
            [F] minecraft:make_record/ size=1
                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [M] Summoned new Marker
                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                [M] data.n on Marker after scale factor of 1.00 is 6
            [R = 6] execute store result score #0 _ run data get entity @s data.n 1.0
            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                [M] Removed 2 from [_] for #0 (now 4)
            [R = 4] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
            [C] execute as 0-0-0-0-0 run function fibonacci/
                [M] Executed 0 commands from function 'minecraft:fibonacci/'
            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
            [F] minecraft:fibonacci/ size=5
                [C] function prologue/
                    [M] Executed 0 commands from function 'minecraft:prologue/'
                [R = 0] function prologue/
                [F] minecraft:prologue/ size=1
                    [C] kill @s
                        [M] Killed Marker
                    [R = 1] kill @s
                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                    [M] data.n on Marker after scale factor of 1.00 is 4
                [R = 4] execute store result score #0 _ run data get entity @s data.n 1.0
                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                [F] minecraft:fibonacci/1 size=11
                    [C] function make_record/
                        [M] Executed 0 commands from function 'minecraft:make_record/'
                    [R = 0] function make_record/
                    [F] minecraft:make_record/ size=1
                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [M] Summoned new Marker
                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                        [M] Removed 1 from [_] for #0 (now 3)
                    [R = 3] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                    [C] execute as 0-0-0-0-0 run function fibonacci/
                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                    [F] minecraft:fibonacci/ size=5
                        [C] function prologue/
                            [M] Executed 0 commands from function 'minecraft:prologue/'
                        [R = 0] function prologue/
                        [F] minecraft:prologue/ size=1
                            [C] kill @s
                                [M] Killed Marker
                            [R = 1] kill @s
                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                            [M] data.n on Marker after scale factor of 1.00 is 3
                        [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                        [C] execute if score #0 _ matches 2.. run function fibonacci/1
                            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                        [F] minecraft:fibonacci/1 size=11
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                [M] Removed 1 from [_] for #0 (now 2)
                            [R = 2] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 2
                                [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1
                                    [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                                [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                                [F] minecraft:fibonacci/1 size=11
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                        [M] Removed 1 from [_] for #0 (now 1)
                                    [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 1
                                        [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                        [M] Modified entity data of Marker
                                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                    [C] function make_record/
                                        [M] Executed 0 commands from function 'minecraft:make_record/'
                                    [R = 0] function make_record/
                                    [F] minecraft:make_record/ size=1
                                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                            [M] Summoned new Marker
                                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [M] data.n on Marker after scale factor of 1.00 is 2
                                    [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                        [M] Removed 2 from [_] for #0 (now 0)
                                    [R = 0] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                    [C] execute as 0-0-0-0-0 run function fibonacci/
                                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                                    [F] minecraft:fibonacci/ size=5
                                        [C] function prologue/
                                            [M] Executed 0 commands from function 'minecraft:prologue/'
                                        [R = 0] function prologue/
                                        [F] minecraft:prologue/ size=1
                                            [C] kill @s
                                                [M] Killed Marker
                                            [R = 1] kill @s
                                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                            [M] data.n on Marker after scale factor of 1.00 is 0
                                        [R = 0] execute store result score #0 _ run data get entity @s data.n 1.0
                                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                            [M] Modified storage minecraft:_
                                        [R = 1] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                        [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                        [M] Marker has the following entity data: 1
                                    [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                    [C] execute store result score #1 _ run data get storage _ result 1.0
                                        [M] result in storage minecraft:_ after scale factor of 1.00 is 0
                                    [R = 0] execute store result score #1 _ run data get storage _ result 1.0
                                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                        [M] Set [_] for #0 to 1
                                    [R = 1] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                [M] Modified entity data of Marker
                            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                [M] data.n on Marker after scale factor of 1.00 is 3
                            [R = 3] execute store result score #0 _ run data get entity @s data.n 1.0
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                [M] Removed 2 from [_] for #0 (now 1)
                            [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 1
                                [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                [M] Marker has the following entity data: 1
                            [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                            [C] execute store result score #1 _ run data get storage _ result 1.0
                                [M] result in storage minecraft:_ after scale factor of 1.00 is 1
                            [R = 1] execute store result score #1 _ run data get storage _ result 1.0
                            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                [M] Set [_] for #0 to 2
                            [R = 2] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                    [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                        [M] Modified entity data of Marker
                    [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                    [C] function make_record/
                        [M] Executed 0 commands from function 'minecraft:make_record/'
                    [R = 0] function make_record/
                    [F] minecraft:make_record/ size=1
                        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [M] Summoned new Marker
                        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                    [C] execute store result score #0 _ run data get entity @s data.n 1.0
                        [M] data.n on Marker after scale factor of 1.00 is 4
                    [R = 4] execute store result score #0 _ run data get entity @s data.n 1.0
                    [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                        [M] Removed 2 from [_] for #0 (now 2)
                    [R = 2] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                    [C] execute as 0-0-0-0-0 run function fibonacci/
                        [M] Executed 0 commands from function 'minecraft:fibonacci/'
                    [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                    [F] minecraft:fibonacci/ size=5
                        [C] function prologue/
                            [M] Executed 0 commands from function 'minecraft:prologue/'
                        [R = 0] function prologue/
                        [F] minecraft:prologue/ size=1
                            [C] kill @s
                                [M] Killed Marker
                            [R = 1] kill @s
                        [C] execute store result score #0 _ run data get entity @s data.n 1.0
                            [M] data.n on Marker after scale factor of 1.00 is 2
                        [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                        [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                        [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                        [C] execute if score #0 _ matches 2.. run function fibonacci/1
                            [M] Executed 0 commands from function 'minecraft:fibonacci/1'
                        [R = 1] execute if score #0 _ matches 2.. run function fibonacci/1
                        [F] minecraft:fibonacci/1 size=11
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                                [M] Removed 1 from [_] for #0 (now 1)
                            [R = 1] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 1
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 1
                                [R = 1] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0 -> 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                    [M] Modified storage minecraft:_
                                [R = 1] execute if score #0 _ matches 1 run data modify storage _ result set value 1
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                            [C] data modify entity @s data.fibonacci(n-1) set from storage _ result
                                [M] Modified entity data of Marker
                            [R = 1] data modify entity @s data.fibonacci(n-1) set from storage _ result
                            [C] function make_record/
                                [M] Executed 0 commands from function 'minecraft:make_record/'
                            [R = 0] function make_record/
                            [F] minecraft:make_record/ size=1
                                [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                                    [M] Summoned new Marker
                                [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
                            [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                [M] data.n on Marker after scale factor of 1.00 is 2
                            [R = 2] execute store result score #0 _ run data get entity @s data.n 1.0
                            [C] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                                [M] Removed 2 from [_] for #0 (now 0)
                            [R = 0] execute store result entity 0-0-0-0-0 data.n int 1.0 run scoreboard players remove #0 _ 2
                            [C] execute as 0-0-0-0-0 run function fibonacci/
                                [M] Executed 0 commands from function 'minecraft:fibonacci/'
                            [R = 1] execute as 0-0-0-0-0 run function fibonacci/
                            [F] minecraft:fibonacci/ size=5
                                [C] function prologue/
                                    [M] Executed 0 commands from function 'minecraft:prologue/'
                                [R = 0] function prologue/
                                [F] minecraft:prologue/ size=1
                                    [C] kill @s
                                        [M] Killed Marker
                                    [R = 1] kill @s
                                [C] execute store result score #0 _ run data get entity @s data.n 1.0
                                    [M] data.n on Marker after scale factor of 1.00 is 0
                                [R = 0] execute store result score #0 _ run data get entity @s data.n 1.0
                                [C] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                    [M] Modified storage minecraft:_
                                [R = 1] execute if score #0 _ matches 0 run data modify storage _ result set value 0
                                [C] execute if score #0 _ matches 1 run data modify storage _ result set value 1 -> 0
                                [C] execute if score #0 _ matches 2.. run function fibonacci/1 -> 0
                            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                                [M] Marker has the following entity data: 1
                            [R = 1] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                            [C] execute store result score #1 _ run data get storage _ result 1.0
                                [M] result in storage minecraft:_ after scale factor of 1.00 is 0
                            [R = 0] execute store result score #1 _ run data get storage _ result 1.0
                            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                                [M] Set [_] for #0 to 1
                            [R = 1] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                    [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                        [M] Marker has the following entity data: 2
                    [R = 2] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                    [C] execute store result score #1 _ run data get storage _ result 1.0
                        [M] result in storage minecraft:_ after scale factor of 1.00 is 1
                    [R = 1] execute store result score #1 _ run data get storage _ result 1.0
                    [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                        [M] Set [_] for #0 to 3
                    [R = 3] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
            [C] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
                [M] Marker has the following entity data: 5
            [R = 5] execute store result score #0 _ run data get entity @s data.fibonacci(n-1)
            [C] execute store result score #1 _ run data get storage _ result 1.0
                [M] result in storage minecraft:_ after scale factor of 1.00 is 3
            [R = 3] execute store result score #1 _ run data get storage _ result 1.0
            [C] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
                [M] Set [_] for #0 to 8
            [R = 8] execute store result storage _ result int 1.0 run scoreboard players operation #0 _ += #1 _
    [C] data get storage _ result
        <b>[M] Storage minecraft:_ has the following contents: 8</b>
    [R = 8] data get storage _ result
    [C] scoreboard objectives remove _
        [M] Removed objective [_]
    [R = 0] scoreboard objectives remove _
</code></pre>
