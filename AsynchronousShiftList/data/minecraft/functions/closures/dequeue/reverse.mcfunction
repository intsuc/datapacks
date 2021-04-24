data modify storage _ closures[1] append from storage _ closures[0][-1]
data remove storage _ closures[0][-1]

execute if data storage _ closures[0][0] run function closures/dequeue/reverse
