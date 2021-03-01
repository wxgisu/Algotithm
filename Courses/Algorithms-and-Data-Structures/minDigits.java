/*
Given array of n digits, 
remove k digits, 
what is the smallerst number the rest digits could form after removal

exmaple1:
input
[1, 2, 3, 4, 5]
k = 2
output
[1, 2, 3]

example2:
input
[4, 1, 2, 3, 5]
k = 1
output
[1, 2, 3, 5]

example3:
input
[4, 5, 1, 2, 3]
k = 2
output
[1, 2, 3]

example4:
[3, 4, 5, 1, 2]
k = 2
output
[3, 1, 2]

strategy:
remove from array until size is array.length - k 
loop through array
    if array[i] < array[i+1]
*/



