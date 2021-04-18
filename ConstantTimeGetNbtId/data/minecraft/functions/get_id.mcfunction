data remove storage _ id
execute if data storage _ tag{} run data modify storage _ id set from storage _ tag_compound
execute if data storage _ tag[0] run function collection
execute unless data storage _ id run function value_or_empty_collection
