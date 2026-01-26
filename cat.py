with open("a.txt", "w") as f:
   f.write("ABC")
with open("a.txt", "r+") as f:
   f.read(2)
   f.write("X")