def fib(num):
    if(num<=2):
        return 1
    else:
        return fib(num-1)+fib(num-2);

def fib_4mil(num):
    lastFib = fib(0)
    fibSeq = [lastFib]
    seq = 1
    while lastFib <= num:
        lastFib = fib(seq)
        if lastFib <= num:
            fibSeq.append(lastFib)
        seq = seq+1
    fibSum = 0
    for x in fibSeq:
        if x%2==0:
            fibSum = fibSum + x
    return fibSum



def even_fib_fast(n):
    fib0 = 1
    fib1 = 1
    sum = 0
    while fib1 < 4000000:
        newfib = fib0 + fib1
        fib0 = fib1
        fib1 = newfib
        
        if newfib % 2 == 0:
            sum+= newfib
    return sum



import time

print("recursive solution")
now = time.time()
print(fib_4mil(4000000))
total = time.time() - now
print("time taken: ", total)


print("iterative solution")
now = time.time()
print(even_fib_fast(4000000))
total = time.time() - now
print("time taken: ", total)