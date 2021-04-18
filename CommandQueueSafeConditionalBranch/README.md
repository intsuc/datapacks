# Command Queue Safe Conditional Branch

## Then

1.  ```mcfunction
    data modify storage _ condition set value 0b
    ```
1.  ```mcfunction
    debug function #main
    ```

### Debug trace

<pre><code>minecraft:unlimit
    [C] gamerule maxCommandChainLength 2147483647
        [M] Gamerule maxCommandChainLength is now set to: 2147483647
    [R = 2147483647] gamerule maxCommandChainLength 2147483647
minecraft:main
    [C] gamerule maxCommandChainLength 2
        [M] Gamerule maxCommandChainLength is now set to: 2
    [R = 2] gamerule maxCommandChainLength 2
    [C] execute unless data storage _ condition run gamerule maxCommandChainLength 3 -> 0
    [C] function #if
        [M] Executed 0 commands from 3 functions
    [R = 0] function #if
    [F] minecraft:unlimit size=1
        [C] gamerule maxCommandChainLength 2147483647
            [M] Gamerule maxCommandChainLength is now set to: 2147483647
        [R = 2147483647] gamerule maxCommandChainLength 2147483647
    [F] minecraft:guard size=1
        [C] execute if data storage _ condition run function then
            [M] Executed 0 commands from function 'minecraft:then'
        [R = 1] execute if data storage _ condition run function then
        <b>[F] minecraft:then size=0</b>
</code></pre>

## Else

1.  ```mcfunction
    data remove storage _ condition
    ```
1.  ```mcfunction
    debug function #main
    ```

### Debug trace

<pre><code>minecraft:unlimit
    [C] gamerule maxCommandChainLength 2147483647
        [M] Gamerule maxCommandChainLength is now set to: 2147483647
    [R = 2147483647] gamerule maxCommandChainLength 2147483647
minecraft:main
    [C] gamerule maxCommandChainLength 2
        [M] Gamerule maxCommandChainLength is now set to: 2
    [R = 2] gamerule maxCommandChainLength 2
    [C] execute unless data storage _ condition run gamerule maxCommandChainLength 3
        [M] Gamerule maxCommandChainLength is now set to: 3
    [R = 1] execute unless data storage _ condition run gamerule maxCommandChainLength 3
    [C] function #if
        [M] Executed 0 commands from 3 functions
    [R = 0] function #if
    [F] minecraft:unlimit size=1
        [C] gamerule maxCommandChainLength 2147483647
            [M] Gamerule maxCommandChainLength is now set to: 2147483647
        [R = 2147483647] gamerule maxCommandChainLength 2147483647
    [F] minecraft:guard size=1
        [C] execute if data storage _ condition run function then -> 0
    <b>[F] minecraft:else size=0</b>
</code></pre>
