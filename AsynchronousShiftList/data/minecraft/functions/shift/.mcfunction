data remove storage _ matched
execute if score index _ < cursor _ run function shift/pop
execute unless data storage _ matched if score index _ > cursor _ run function shift/push
execute unless data storage _ matched run function shift/match
