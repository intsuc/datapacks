scoreboard objectives add _ dummy
  function make_record/
  data modify entity 0-0-0-0-0 data.n set value 6
  execute as 0-0-0-0-0 run function fibonacci/
  data get storage _ result
scoreboard objectives remove _
