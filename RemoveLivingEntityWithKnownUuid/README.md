# Remove `LivingEntity` with Known UUID

1.  ```mcfunction
    function init
    ```
---
1.  ```mcfunction
    debug function main
    ```

### Debug trace

<pre><code>minecraft:main
    [C] execute in minecraft:overworld run summon minecraft:zombie 8.0 0.0 8.0 {UUID: [I; 0, 0, 0, 0]}
        [M] Summoned new Zombie
    [R = 1] execute in minecraft:overworld run summon minecraft:zombie 8.0 0.0 8.0 {UUID: [I; 0, 0, 0, 0]}
    [C] execute in minecraft:the_nether as 0-0-0-0-0 positioned as @s run function remove
        [M] Executed 0 commands from function 'minecraft:remove'
    [R = 1] execute in minecraft:the_nether as 0-0-0-0-0 positioned as @s run function remove
    [F] minecraft:remove size=3
        [C] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
            [M] Summoned new Marker
        [R = 1] summon minecraft:marker ~ ~ ~ {UUID: [I; 0, 0, 0, 0]}
        [C] teleport @s ~ ~ ~
            [M] Teleported Zombie to 8.0, 0.0, 8.0
        [R = 1] teleport @s ~ ~ ~
        [C] kill 0-0-0-0-0
            [M] Killed Marker
        [R = 1] kill 0-0-0-0-0
    [C] data get entity 0-0-0-0-0
        <b>[E] No entity was found</b>
</code></pre>
