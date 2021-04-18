data modify storage _ head set from storage _ tag[0]
execute store success storage _ numeric_array byte 1.0 run data modify storage _ tag[0] set from storage _ conversion_checker
# See: https://bugs.mojang.com/browse/MC-178997
execute if data storage _ {numeric_array: false} store success storage _ numeric_array byte 1.0 run data modify storage _ tag[0] set from storage _ conversion_checker'
data modify storage _ tag[0] set from storage _ head

execute if data storage _ {numeric_array: true} run data modify storage _ id set from storage _ numeric_collection_id
execute if data storage _ {numeric_array: false} run data modify storage _ id set from storage _ tag_list
