import random
items = [ "apple", "bag", "ball", "band", "basin", "basket", "bath", "bed", "bee", "bell", "berry", "bird", "blade", "board", "boat", "bone", "book", "boot", "bottle", "box", "boy", "branch", "brick", "bridge", "brush", "bucket", "bulb", "button", "cake", "camera", "card", "cart", "carriage", "cat", "chain", "cheese", "chest", "chin", "church", "circle", "clock", "cloud", "coat", "collar", "comb", "cord", "cow", "cup", "curtain", "cushion", "dog", "door", "drain", "drawer", "dress", "drop", "ear", "egg", "engine", "eye", "face", "feather", "fish", "flag", "floor", "fly", "fork", "fowl", "frame", "glove", "goat", "gun", "hair", "hammer", "hat", "head", "hook", "horse", "hospital", "house", "island", "jewel", "kettle", "key", "leaf", "library", "line", "lip", "lock", "map", "match", "nail", "neck", "needle", "nerve", "net", "nose", "nut", "office", "orange", "oven", "parcel", "pen", "pencil", "picture", "pig", "pin", "pipe", "plane", "plate", "plow", "pocket", "rat", "receipt", "ring", "sail", "scissors", "seed", "sheep", "shelf", "ship", "shirt", "shoe", "skin", "skirt", "snake", "sock", "spade", "sponge", "spoon", "spring", "square", "stamp", "star", "station", "stem", "stick", "stocking", "stomach", "table", "tail", "thread", "throat", "thumb", "ticket", "toe", "tongue", "tooth", "town", "train", "tray", "tree", "trousers", "umbrella", "wall", "watch", "wheel", "whistle", "window", "wing", "wire", "worm" ]

ops = ['sold', 'bought', 'stock', 'inventory', 'top', 'remove']

with open('input_lg.txt', 'w') as data:
    for i in items:
        wsprice = round(random.uniform(0.10, 100.99), 2)
        rsprice = round(random.uniform(wsprice, wsprice*2))
        cnt = random.randrange(500)
        data.write(f'add {i} {cnt} {wsprice} {rsprice} \n')

    dels = 0
    for x in range(0, 50000):
        op = random.randrange(len(ops))
        item = items[random.randrange(len(items))]
        if op == 0 or op == 1:
            cnt = random.randrange(300)
            data.write(f'{ops[op]} {item} {cnt}\n')
        elif op == 2 or op == 5:
            if op == 5:
                if dels < len(items) / 2:
                    dels += 1
                    data.write(f'{ops[op]} {items[random.randrange(len(items))]}\n')
            else:
                data.write(f'{ops[op]} {items[random.randrange(len(items))]}\n')
        else:
            data.write(f'{ops[op]}\n')
