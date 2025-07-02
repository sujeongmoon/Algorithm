def solution(arr1, arr2):    
#     행렬의 곱셈이 가능하니까 예외처리는 하지 않아도 되는데, 시험에 행렬 곱셈이 불가능한 경우는 불가능하다고 나오도록 할 수도 있음!

    #일단 문제를 나누어서 풀 수 있도록 해주면 좋다. 행렬의 곱셈의 결과값을 어떻게 저장할 것인지를 고려해봐야 함.
    # arr1과 arr2의 행과 열을 따로 저장을 해두고?? 그에 따라서 행렬을 만들어 두고 그건 0으로 초기화를 해둔다..?
    
    r1 = len(arr1) #arr1의 행의 개수
    c1 = len(arr1[0]) #arr1 열개수
    r2, c2 = len(arr2), len(arr2[0])
    
    #이렇게 해두면 결과행렬의 크기 구하기
    ret=[[0] * c2 for _ in range(r1)] #r1이라는 해만큼 반복하면서 각각을 0으로 초기화를 한다??
    
    for i in range(r1):
        for j in range(c2):
            # r1*c1*c2가 된다...?
            for k in range(c1):
                
                ret[i][j] += arr1[i][k] * arr2[k][j] 
    
    return ret