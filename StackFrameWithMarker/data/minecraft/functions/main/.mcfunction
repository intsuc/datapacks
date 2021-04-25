# Open a scoreboard for integer arithmetic.
scoreboard objectives add _ dummy

  # Call the fibonacci function with `{n: 6}`.
  function make_frame/
  data modify entity 0-0-0-0-0 data.n set value 6
  execute as 0-0-0-0-0 run function fibonacci/

  # The return value of a function is stored outside the stack frame, because stack frames are managed in a LIFO manner.
  data get storage _ result

# Close the scoreboard.
scoreboard objectives remove _
