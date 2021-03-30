import math

def solve(N, A):
    dp = []
    dp1 = {}
    for i in range(0, 2 * N):
        dp.append([0] * (2 * N))
        for j in range(0, 2 * N):
            dp[i][j] = math.gcd(A[i], A[j])
    map = [0] * (2 * N)
    return fun_helper(N, A, map, N, dp, dp1)
    



def fun_helper(N, A, map, a, dp, dp1):
    if (a == 0):
        return 0
    maxGcd, indices = gcd_helper(N, A, map, dp)
    mark = (a, tuple(map), indices)
    if (mark in dp1.keys()):
        return dp1[mark]
    max_output = 0
    for i in range(0, len(indices)):
        map[indices[i][0]] = True
        map[indices[i][1]] = True
        current_result = fun_helper(N, A, map, a - 1, dp, dp1)
        max_output = max(current_result + (a * dp[indices[i][0][indices][i][1]]), max_output)
        map[indices[i][0]] = False
        map[indices[i][1]] = False

    dp1[mark] = max_output
    return max_output





def gcd_helper(N, A, map, dp):
    count = {}
    maxGcd = 0
    for i in range(0, 2 * N):
        if (map[i]):
            continue
        for j in range(i + 1, 2 * N):
            if (i == j or map[j]):
                continue
            currentGcd = dp[i][j]
            if (currentGcd >= maxGcd):
                maxGcd = currentGcd
                indices = [i, j]
                if (maxGcd in count.keys()):
                    count[maxGcd].append(indices)
                else:
                    count[maxGcd] = [indices]
    indices1 = count[maxGcd]
    for i in range(0, len(indices1)):
        indices1[i] = tuple(indices1[i])
    indices1 = tuple(indices1)
    return maxGcd,indices1                    


     
    
N = int(input())
A = []
for i in range(2 * N):
    k = int(input())
    A.append(k)
ans = solve(N, A)
print(ans)
