def count_lines(path):
   f = open(path, "r")
   lines = f.read()
   return len(lines)
print(count_lines("data.txt"))