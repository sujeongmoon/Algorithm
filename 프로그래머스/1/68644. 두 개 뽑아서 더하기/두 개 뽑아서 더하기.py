def solution(numbers):
    #  가장 쉬운, 난이도 낮은 문제
    #  서로 다른 인덱스의 수를 더하고 오름차순 해라.
    #  더해서 나오는 수가 중복인 경우는 리스트에 두 번 담기지 않음에 주의
    
    # ==> 문제 분석하는 시간 꼭 가지기
    
    #numbers의 모든 수는 0 이상 100 이하 => 시간복잡도는 신경쓰지 않아도 되는구나 를 고려..(왜?)
    
    '''
    1. 배열에서 두 수를 선택하고 선택한 두 수의 합을 구한다
    2. 합을 구한 수를 새로운 배열에 저장하고 중복값을 제거한다
    3. 배열을 최종적으로 오름차순으로 정렬하고 리턴한다.
    '''
    
#     임시배열
    ret = []
    
    for i in range(len(numbers)):
        for j in range (i+1, len(numbers)):
            ret.append(numbers[i] + numbers[j])
    # print(ret)
    # 중복된 수가 많고 정리도 안 돼있다.
    # 보통 set을 쓰게 하긴 하는데, 못 쓰게 할 경우도 고려해봐야함..
    # print(set(ret))
    ret = sorted(set(ret))
    
    return ret