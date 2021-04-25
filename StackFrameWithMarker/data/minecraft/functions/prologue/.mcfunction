# Remove the current stack frame from the level.
#
# After this function, a new entity with UUID `0-0-0-0-0` can be added to the level, i.e. a new stack frame can be created.
# In addition, to access the current stack frame, use `@s`.
kill @s
