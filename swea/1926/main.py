N = int(input())
for i in range(1, N+1):
    s = str(i)
    count = s.count('3') + s.count('6') + s.count('9')
    if count == 0:
        print(i, end=' ')
    else:
        print('-' * count, end=' ')
