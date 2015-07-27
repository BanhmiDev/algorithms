#!/usr/bin/env python3

def primes_to(n):
    list = []
    sieve = [True] * (n+1)

    for prime in range(2, n+1):
        if (sieve[prime]):
            list.append(prime)
        for i in range(prime, n+1, prime): # Remove multiples
            sieve[i] = False

    return list

print(primes_to(100))
