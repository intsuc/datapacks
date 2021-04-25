# Load the malformed command storage file to throw `java.lang.OutOfMemoryError`.
#
# The command storage file is a small uncompressed file of 10 bytes:
#   0A          | header of compound tag
#   00 00       | ""
#   07          | header of byte array tag
#   00 00       | ""
#   7F FF FF FF | size of byte array tag (2147483647)
#
# When the JVM tries to load the byte array tag, array allocation for a size exceeding the VM limit will happen.

data get storage _
