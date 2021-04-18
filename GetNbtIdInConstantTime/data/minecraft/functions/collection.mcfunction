execute store success storage _ numeric_collection byte 1.0 run data get storage _ tag[0] 0.0
execute if data storage _ {numeric_collection: true} run function numeric_collection
execute if data storage _ {numeric_collection: false} run data modify storage _ id set from storage _ tag_list
