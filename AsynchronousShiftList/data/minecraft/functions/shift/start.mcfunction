function closures/dequeue/
data modify storage _ tag set from storage _ closure.tag
execute store result score index _ run data get storage _ closure.idx

data modify storage _ is_shifting set from storage _ inhabitant
