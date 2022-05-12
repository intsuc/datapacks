data modify storage 0 c append from storage 0 c[-1]
data remove storage 0 c[-2]
data modify storage 0 c append from storage 0 c[-1]
data modify storage 0 c append value 1
function --
function fib
data modify storage 0 c append from storage 0 c[-3]
data modify storage 0 c append value 2
function --
function fib
function -2b
data remove storage 0 c[-2]
scoreboard players set 0 0 1