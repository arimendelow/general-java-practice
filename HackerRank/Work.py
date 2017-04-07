if __name__ == '__main__':
    N = int(raw_input("how many commands? "))
    
    commands = []
    arr = []
    i = 0
    while i < N:
        commands.append(raw_input("give me commands. "))
        i += 1
    
    i = 0
    # insert, print, remove, append, sort, pop, reverse
    
    for i in range(0,N):
        if commands[i][0:6] == 'insert':
            #print int(commands[i][7])
            #print int(commands[i][9:len(commands[i])])
            arr.insert(int(commands[i][7]),int(commands[i][9:len(commands[i])]))
        elif commands[i][0:6] == 'remove':
            arr.remove(int(commands[i][7:len(commands[i])]))
        elif commands[i][0:6] == 'append':
            arr.append(int(commands[i][7:len(commands[i])]))
        elif commands[i][0:4] == 'sort':
            arr.sort()
        elif commands[i][0:3] == 'pop':
            arr.pop()
        elif commands[i][0:7] == 'reverse':
            arr.reverse()
        else:
            print arr
        
        