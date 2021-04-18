# Because NBT depth on copying is not limited, we can create an NBT of arbitrary depth recursively as follows:
#     {}
#   → {_: {}}
#   → {_: {_: {}}}
#   → {_: {_: {_: {}}}}
#   → …
#
# Eventually, `java.lang.StackOverflowError` will be thrown.
#
# See: https://bugs.mojang.com/browse/MC-201769

data modify storage _ _ set from storage _ {}
function throw
