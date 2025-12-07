def check_string(a: str, b: str) -> bool:
    if len(a) != len(b): return False
    
    na: str = a
    nb: str = b
    
    for chara, charb in zip(na, nb):
        if chara == charb:
            continue
        else:
            na = [charb if i == chara else i for i in na]
    
    na = ''.join(na)
    
    return na == nb
