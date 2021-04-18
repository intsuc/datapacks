data modify storage _ tag_end set value 0b
data modify storage _ tag_byte set value 1b
data modify storage _ tag_short set value 2b
data modify storage _ tag_int set value 3b
data modify storage _ tag_long set value 4b
data modify storage _ tag_float set value 5b
data modify storage _ tag_double set value 6b
data modify storage _ tag_byte_array set value 7b
data modify storage _ tag_string set value 8b
data modify storage _ tag_list set value 9b
data modify storage _ tag_compound set value 10b
data modify storage _ tag_int_array set value 11b
data modify storage _ tag_long_array set value 12b

data modify storage _ numeric_collection_ids set value [[], [], [], [], [], []]
execute store result storage _ numeric_collection_ids[0][] byte 1.0 run data get storage _ tag_byte_array
execute store result storage _ numeric_collection_ids[1][] short 1.0 run data get storage _ tag_list
execute store result storage _ numeric_collection_ids[2][] float 1.0 run data get storage _ tag_list
execute store result storage _ numeric_collection_ids[3][] double 1.0 run data get storage _ tag_list
execute store result storage _ numeric_collection_ids[4][] int 1.0 run data get storage _ tag_int_array
execute store result storage _ numeric_collection_ids[5][] long 1.0 run data get storage _ tag_long_array

data modify storage _ implicit_conversion_checker set value 0s

data modify storage _ value_or_empty_collection_id_tags set value []
data modify storage _ value_or_empty_collection_id_tags append value [1b]
data modify storage _ value_or_empty_collection_id_tags append value [2s]
data modify storage _ value_or_empty_collection_id_tags append value [3]
data modify storage _ value_or_empty_collection_id_tags append value [4L]
data modify storage _ value_or_empty_collection_id_tags append value [5.0f]
data modify storage _ value_or_empty_collection_id_tags append value [6.0d]
data modify storage _ value_or_empty_collection_id_tags append value [[B; 0b, 0b, 0b, 0b, 0b, 0b, 0b]]
data modify storage _ value_or_empty_collection_id_tags append value ["00000000"]
data modify storage _ value_or_empty_collection_id_tags append value [[0b, 0b, 0b, 0b, 0b, 0b, 0b, 0b, 0b]]
data modify storage _ value_or_empty_collection_id_tags append value [[I; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]
data modify storage _ value_or_empty_collection_id_tags append value [[L; 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L]]
