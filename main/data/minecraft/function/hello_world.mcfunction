say Hello, world!
scoreboard players set #a _ 10
scoreboard players set #b _ 20
scoreboard players operation #b _ = #a _
scoreboard players operation #b _ += #a _
scoreboard players operation #b _ -= #a _
scoreboard players operation #b _ *= #a _
scoreboard players operation #b _ /= #a _
scoreboard players operation #b _ %= #a _
scoreboard players operation #b _ < #a _
scoreboard players operation #b _ > #a _
scoreboard players operation #b _ >< #a _
scoreboard players set #b _ 0
scoreboard players add #b _ 1
scoreboard players remove #b _ 2
scoreboard players set #0 _ 3
scoreboard players operation #b _ *= #0 _
scoreboard players set #0 _ 4
scoreboard players operation #b _ /= #0 _
scoreboard players set #0 _ 5
scoreboard players operation #b _ %= #0 _
scoreboard players set #0 _ 6
scoreboard players operation #b _ < #0 _
scoreboard players set #0 _ 7
scoreboard players operation #b _ > #0 _
scoreboard players add #b _ 2147483647
scoreboard players set #0 _ -2147483648
scoreboard players operation #b _ += #0 _
scoreboard players remove #b _ 1
scoreboard players remove #b _ 2147483647
scoreboard players set #0 _ -2147483648
scoreboard players operation #b _ -= #0 _
scoreboard players add #b _ 1
# comment
data merge storage global_storage {a:1,b:{c:2}}
data merge storage global_storage {}
data remove storage global_storage {}.[].a.[0].[-1].[{}].b{}
data get storage local_storage a.b.[1].[2].[0].[-1]
data get storage local_storage a.b.[1].[2].[0].[-1] 2.0
data modify storage local_storage a.b.[1].[2].[0].[-1] append from storage a a
data modify storage local_storage a.b.[1].[2].[0].[-1] append string storage a a
data modify storage local_storage a.b.[1].[2].[0].[-1] append value {a:1,b:{c:2}}
data modify storage local_storage a.b.[1].[2].[0].[-1] append value {a:1}
data modify storage local_storage a.b.[1].[2].[0].[-1] insert 2 value {a:1}
function hello_world
function f
