def solution(N, stages):
    #답으로 실패율이 나와야하는 것.
    #실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라
    #동점처리 고려해야함
        
        
        ###########
        #스테이지별 도전자 수를 구함
    challenger = [0] * (N+2) #왜냐면 스테이지는 1부터니까.. 0번 인덱스 버리고 1번부터 쓴대?? challenger의 1에는 1번스테이지에 몇명이냐, 2에는 2번스테이지에 머무는 수... 챌린지의 n+1에는 n번 스테이지를 클리어한 사람 수가 들어가게! (0번인덱스 버리고 n+1까지 필요)
        
    for stage in stages:
        challenger[stage]+=1
        
        #스테이지별 실패 도전자 수 계산
    fails={}
    total = len(stages)
    for i in range(1, N+1):
        if challenger[i]==0: #도전한 사람 없음, 실패율 = 0
            fails[i] = 0 #fails는 딕셔너리, i는 key고 0이 value
                
        else:
            fails[i] = challenger[i]/total #실패율
            total -= challenger[i] #다음 스테이지 실패율을 구하기 위해 현재 스테이지 인원수를 뺌
        
    #딕셔너리 정렬하는 법 알고있어야함 필수
    res = sorted(fails, key=lambda x:fails[x], reverse=True)
    
    
    return res