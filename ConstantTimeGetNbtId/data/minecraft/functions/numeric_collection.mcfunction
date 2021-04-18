data modify storage _ numeric_collection_ids[] append from storage _ tag[0]
execute store result storage _ numeric_collection_id byte 1.0 run data get storage _ numeric_collection_ids[][-2] 1.0
data remove storage _ numeric_collection_ids[][1]

execute if data storage _ {numeric_collection_id: 9b} run data modify storage _ numeric_collection set value false
execute unless data storage _ {numeric_collection_id: 9b} run function list_or_numeric_array
