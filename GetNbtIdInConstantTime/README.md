# Get NBT Id in Constant-Time

1.  ```mcfunction
    function init
    ```
---

## Byte

1.  ```mcfunction
    data modify storage _ tag set value 0b
    ```
1.  ```mcfunction
    function get_id
    ```
1.  ```mcfunction
    data get storage _ id
    # Storage minecraft:_ has the following contents: 1b
    ```
