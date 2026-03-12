def find_list(a_list: list[int], k: int) -> int:
    pos = 0
    while pos < len(a_list) and a_list[pos] != k:
        pos += 1
    
    return pos if pos < len(a_list) else -1
