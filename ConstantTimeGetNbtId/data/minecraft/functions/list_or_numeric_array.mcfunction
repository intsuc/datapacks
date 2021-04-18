data modify storage _ head set from storage _ tag[0]
execute store success storage _ numeric_array byte 1.0 run data modify storage _ tag[0] set from storage _ implicit_conversion_checker
data modify storage _ tag[0] set from storage _ head

execute if data storage _ {numeric_array: true} run data modify storage _ id set from storage _ numeric_collection_id
execute if data storage _ {numeric_array: false} run data modify storage _ id set from storage _ tag_list
