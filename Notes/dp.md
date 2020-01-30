# Dynamic Programming
## Concepts
**What is dynamic programming?**\
DP is recursion with memoization.

**What is dynamic programming good for?**\
DP is good for solving optimization problems.

**Steps for solving DP problem:**
1. Define subproblem
2. Guess for subproblem
3. Relate subproglems (make sure they form <u>D</u>irected <u>A</u>cyclic <u>G</u>raph)
4. Recurse and memoize
5. Solve original problem

[Source: MIT6006-19](https://www.youtube.com/watch?v=OQ5jsbhAv_M&vl=en)

**Recursion tree**\
Recursion tree shows parent-child relationship for all recursive calls. See example in ITA3_p364_figure15.3 (ITA3: Introduction to Algorithms 3rd Edition).

_Question:_ Why does the recursion tree has 2<sup>n</sup> nodes?\
_Answer:_ See ITA3S_15.1.md.

**Two approaches to implement DP**
- Top-down with memoization
- Bottom-up method

## Problems
#### Rod cutting
> Given a rod of length n inches and a
table of prices $p_i$ for $i = 1, 2, ..., n$, determine the maximum revenue $r_n$ obtainable by cutting up the rod and selling the pieces.

**Naive recursive solution**
```python
cut_rod(p,n)
  if n == 0
    return 0
  q = -infinite
  for i = 1 to n
    q = max(q, p[i] + cut_rod(p, n-1))
  return q
```
**Memoized top-down solution**
```python
memoized_cut_rod(p,n)
  let r[0..n] be a new array with n elements
  for i = 0 to n
    r[i] = - infinite
  return memoized_cut_rod_aux(p,n,r)

memoized_cut_rod_aux(p,n,r)
  if r[n] >= 0
    return r[n]
  if n == 0
    q = 0
  else
    q = - infinite
    for i = 1 to n
      q = max(q, p[i] + memoized_cut_rod_aux(p, n-i, r))
  r[n] = q
  return q
```
