package JavaCodingExamplePkg;

public class EucledianAlgorithm {
	private static int gcd(int a, int b) 
	{
		if (b == 0) 
			return a; 
		else if(a ==0) 
			return b;
		else
			return gcd(b, a % b);
	}
	public static void main(String[] args) {
		int n1 = 150;
		int n2 = 345;
		int r;
		
		System.out.println(gcd(n1,n2));
		while(n2!=0) {
			r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		
		System.out.println(n1);
	}
}



/*
 * 
 * //Dividend = Divisor * Q + Rem; 
 * As per Eucledian Algorithm 
 * Step 1 = Biggest Number of two will become Dividend 
 * Step 2 = Divide and find Q, Rem
 * Step 3 = If the Rem!=0, Dividend <= Divisor, Divisor <= Rem , do Step 2
 * Step 4 = If the Rem==0, then Divisor is the Answer
 * 
 * 

29 /\ 3 = 9; (3 goes - whole - into 29; 9 times)  
29 % 3 = 2; (the integer division of 29 into 3 has a remainder of 2)  
9 * 3 + 2 = 29; (9 goes into 29 3 times (and 3 goes into 29 9 times), with a remainder of 2)  

Note that if m is smaller than n (i.e. m < n), then n goes into m 0 times (m /\ n = 0), 
so the remainder of the integer division will be m (m % n = m, because o * n + p = m and so (0*n) + p = 0 + p = p = m);

m /\ n = 0( n goes into m ; 0 times)
2/\3  = 0; (3 goes whole into 2; 0 times)
2 % 3 = 2; Here remainder is m
m %n =m;
So now (divisor * Q) + Rem => (3 * 0) + 2 = 2 but 2 => m



"the greatest common divisor of two numbers does not change if the larger number is replaced by its difference with the smaller number."

(wikipedia - Euclidean algorithm)

So, modulo:
Modulo returns the remainder of the integer divison between two integers. Integer division is divison without fractions or floating points. Let's denote integer division as m /\ n.

m /\ n = o;  
m % n = p;  
o * n + p = m;  
As an example,

29 /\ 3 = 9; (3 goes - whole - into 29 9 times)  
29 % 3 = 2; (the integer division of 29 into 3 has a remainder of 2)  
9 * 3 + 2 = 29; (9 goes into 29 3 times (and 3 goes into 29 9 times), with a remainder of 2)  
Note that if m is smaller than n (i.e. m < n), then n goes into m 0 times (m /\ n = 0), 
so the remainder of the integer division will be m (m % n = m, because o * n + p = m and so (0*n) + p = 0 + p = p = m);

So, how does the function work? let's try using it.

1 - gcd(m, n), m < n
So, if we start out gcd(m, n) with an m that is smaller than n,
 the only thing that happens on the next nested call to gcd is 
 that the order of the arguments changes: gcd(n, m % n) = gcd(n, m);

2 - gcd(n, m), m < n
Okay, so now the first argument larger than the second.
According to euclid's algorithm, we want to do something to the larger of the two numbers. 
We want to replace it with the difference between it and the smaller number. 
We could do m - n a bunch of times. But what m % n does is the exact 
same as subtracting n from m as many times as possible before doing so 
would result in a negative number. Doing a subtraction would look like (((m - n) - n) - n) - n) and so on. 
But if we expand that out, we get: m - (n * o). Because o * n + p = m, 
we can see that m - (n * o) = p and p = m % n. So, repeatedly subtracting the smaller from the larger
 is the same as doing modulo of the larger with the smaller.
In the next step, the second argument may be 0 (if n was a divisor of m). In this case, the function returns n. 
this is correct because n is a divisor of itself and also, as we've seen, a divisor of m.
Or, the second argument may be smaller than n. That is because the remainder of the integer divison of m 
into n must be smaller than n - this is because,
 if the remainder of the division were larger than n, 
 then n could have fit into m one more time, which it didn't; this is an absurd result. [result of mod operation will always be lesser than the divisor]
 Assuming that n is not 0, then the second argument (let's call it p) is smaller than n.
So, we are now calling gcd(n, p), where p < n.

3 - gcd(n, p), p < n
What happens now? well, we are exactly in the same place as we were in the previous paragraph. 
Now we just repeat that step, i.e. 
we will continue to call gcd(a, b), until the smaller of the two numbers 
that are passed into gcd(a ,b) is a divisor of the larger of the two numbers, (meaning that a % b = 0) in 
which case you simply return the smaller of the two numbers.


29 % 3 == m %n
29-3 = 26 (01)
26-3 = 23 (02)
23-3 = 20 (03)
20-3 = 17 (04)
17-3 = 15 (05)
15-3 = 12 (06)
12-3 = 11 (07)
11-3 =  8  (08)
8-3 = 5      (09)
5-3 = 2 (BINGO!) [9 times mutiply with 3 = 27 then add 2 = gives 29] [29 % 3 gives 9]
[result of mod operation will always be lesser than the divisor]
2-3 = -1

repeatedly subtracting the smaller from the larger
is the same as doing modulo of the larger with the smaller.

https://stackoverflow.com/questions/41732993/how-to-use-euclids-algorithm-to-find-gcf-gcd



 */