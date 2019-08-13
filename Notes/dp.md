# Dynamic Programming
## Concepts
**What is dynamic programming?**\
DP is recursion with memorization.

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

_Question: Why does the recursion tree has 2<sup>n</sup> nodes?_

#### Recursive DP
- memoize
- re-use solutions to subproblems
- time = # of subproblems * time/subproblem

#### Bottom-up DP
- same computation as recursion
- <u>topological sort</u> of subproblem dependency DAG
- Advantage: save space. only need constant space because only the last two values are need to be memoized
```
fib = {} # hashmap for remembering solutions to subproblemsfor k in range(n):
  if k <= 2: f = 1
  else: f = fib[k-1] + fib[k-2]
  fib[k] = f
return fib[n]
```

#### Shortest Paths
(s, v) for all v\
Tool: guessing and try ALL guesses (& take the best one)
- Idea 1: guess first edge
- Idea 2: guess last edge
  - delta(s,v) = min(delta(s,u) + delta(u,v)) where u is the last edge leades to v
- Time complexity
  - Infinite time on graphs with cycles
  - DAG: theta(E+v) (E is number of total edges?)
    - time for subproblem delta(s,v) = indegree(v) + 1 (Why +1?)
    - total time = sum of indegree(v) over all v = theta(E + v)
- Subproblem dependency should be acyclic
- For cyclic graphs
  - explode cyclic graphs into k dimentions (k as number of possible starting nodes that could lead to v? since all nodes will lead to v so k is equal to v?)
- Checkout Bellman-Ford algorithm
