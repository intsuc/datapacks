data modify storage _ value_or_empty_collection_id_tags[] append from storage _ tag
execute store result storage _ id byte 1.0 run data get storage _ value_or_empty_collection_id_tags[][-2]
data remove storage _ value_or_empty_collection_id_tags[][1]
